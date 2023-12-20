package org.demointernetshop.services;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.cart.CartChangeDto;
import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.entity.Cart;
import org.demointernetshop.entity.CartItem;
import org.demointernetshop.entity.Product;
import org.demointernetshop.repository.CartItemRepository;
import org.demointernetshop.repository.CartRepository;
import org.demointernetshop.repository.CategoryRepository;
import org.demointernetshop.repository.ProductRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.demointernetshop.services.utils.Converters;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final Converters converters;
    private final ProductRepository productRepository;

    public CartDto getCart(Integer userId) {
        Cart cartByUserId = cartRepository.findByUserIdWithCartItems(userId);
        return converters.fromCartToDto(cartByUserId);
    }

    public CartDto updateCart(Integer userId, CartChangeDto request) {
        Cart cartByUserId = cartRepository.findByUserIdWithCartItems(userId);

        Optional<CartItem> cartItemOptional = cartByUserId.getCartItems().stream()
                .filter(ci -> ci.getProduct().getId().equals(request.getProduct_id()))
                .findFirst();

        if (cartItemOptional.isPresent()) {
            CartItem cartItem = cartItemOptional.get();
            cartItem.setQuantity(request.getCount());
        } else {
            Product product = productRepository.findById(request.getProduct_id()).orElseThrow(() -> new NotFoundException("Product not found"));

            CartItem newCartItem = new CartItem();
            newCartItem.setProduct(product);
            newCartItem.setQuantity(request.getCount());
            newCartItem.setCart(cartByUserId);
        }

        cartByUserId = cartRepository.save(cartByUserId);
        return converters.fromCartToDto(cartByUserId);
        }
}
