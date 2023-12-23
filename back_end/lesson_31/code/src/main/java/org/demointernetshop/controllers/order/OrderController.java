package org.demointernetshop.controllers.order;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.order.OrderDto;
import org.demointernetshop.model.dto.order.OrderRequestDto;
import org.demointernetshop.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public OrderDto createOrder(@RequestBody OrderRequestDto request){
        return orderService.createOrder(request);
    }

    @DeleteMapping("{order_id}")
    public void deleteOrder(@PathVariable("order_id") Integer orderId){
        orderService.deleteOrder(orderId);
    }



}
