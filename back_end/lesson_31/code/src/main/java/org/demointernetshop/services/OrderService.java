package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.order.OrderDto;
import org.demointernetshop.model.dto.order.OrderRequestDto;
import org.demointernetshop.model.dto.product.ProductShortInfoDto;
import org.demointernetshop.model.entity.Order;
import org.demointernetshop.model.entity.OrderItem;
import org.demointernetshop.model.entity.User;
import org.demointernetshop.model.entity.cart.Cart;
import org.demointernetshop.model.entity.product.ProductInfo;
import org.demointernetshop.repository.*;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.DefaultValues;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final DefaultValues defaultValues;

    private final ProductInfoRepository productInfoRepository;
    private final OrderItemRepository orderItemRepository;


    public OrderDto createOrder(OrderRequestDto request) {
        /*
          private Integer cartId;
          private Integer userId;
          private List<ProductShortInfoDto> products;

          при этом
          private Integer id;
          private String name;
          private BigDecimal price;
          private Integer quantity;


         должны создать

         public class Order {

    private Integer id;
    private User user;
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private LocalDateTime createData;

    в котором OrderItem содержит

    private Integer id; -> создается автоматически базой данных
    private Product product; -> получаем из ProductShortInfoDto.getId
    private int quantity;    -> получаем из ProductShortInfoDto.getQuantity
    private BigDecimal price;-> получаем из ProductShortInfoDto.getPrice
    private Order order;

         */

        Cart cartById = cartRepository.findById(request.getCartId())
                .orElseThrow(() -> new NotFoundException("Cart with id " + request.getCartId() + " not found!"));

        User userById = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("User with id " + request.getUserId() + " not found!"));


        Order newOrder = Order.builder()
                .user(userById)
                .totalAmount(calculatorTotalAmount(request))
                .orderStatus(defaultValues.getDefaultOrderStatus())
                .paymentMethod(defaultValues.getDefaultPaymentMethod())
                .paymentStatus(defaultValues.getDefaultPaymentStatus())
                .createData(LocalDateTime.now())
                .build();

        Order savedOrder = orderRepository.save(newOrder);



        List<OrderItem> orderItems = request.getProducts().stream()
                .map(productDto -> {
                    ProductInfo productInfo = productInfoRepository.findByProductId(productDto.getId())
                            .orElseThrow(() -> new NotFoundException("ProductInfo not found!"));
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(productInfo.getProduct());
                    orderItem.setQuantity(productDto.getQuantity());
                    orderItem.setPrice(productInfo.getPrice());
                    orderItem.setOrder(savedOrder);
                    return orderItemRepository.save(orderItem);
                })
                .toList();

        savedOrder.setOrderItems(orderItems);

        clearCartItems(cartById);

        return buidOrderDto(savedOrder, request);

    }

    private OrderDto buidOrderDto(Order savedOrder,OrderRequestDto request ) {
        return OrderDto.builder()
                .id(savedOrder.getId())
                .userId(savedOrder.getUser().getId())
                .products(request.getProducts())
                .orderStatus(savedOrder.getOrderStatus().getStatus())
                .paymentMethod(savedOrder.getPaymentMethod().getMethod())
                .payment_status(savedOrder.getPaymentStatus().getStatus())
                .createData(savedOrder.getCreateData())
                .build();
    }

    private BigDecimal calculatorTotalAmount(OrderRequestDto request){
        List<ProductShortInfoDto> productShortInfoDtos = request.getProducts();

        return productShortInfoDtos.stream()
                .map(productShortInfoDto -> productShortInfoDto.getPrice().multiply(BigDecimal.valueOf(productShortInfoDto.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    private void clearCartItems(Cart cart) {
        cartItemRepository.deleteByCart(cart);
        cart.setCartItems(Collections.emptyList());
        cartRepository.save(cart);
    }

    public void deleteOrder(Integer orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()){
            Order order = orderOptional.get();
            orderRepository.delete(order);
        } else {
            throw new NotFoundException("Order with id " + orderId + " not found!");
        }

    }
}
