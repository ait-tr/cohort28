package org.demointernetshop.controllers.cart;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.cart.CartChangeDto;
import org.demointernetshop.dto.cart.CartDto;
import org.demointernetshop.dto.product.CategoryDto;
import org.demointernetshop.dto.product.CategoryWithPricesDto;
import org.demointernetshop.services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class CartController {

    private final CartService cartService;

    @GetMapping("/{user_id}/cart")
    public CartDto getCart(@PathVariable("user_id") Integer userId){
        return cartService.getCart(userId);
    }

    @PutMapping("/{user_id}/cart")
    public CartDto updateCart(@PathVariable("user_id") Integer userId, @RequestBody() CartChangeDto request){
        return cartService.updateCart(userId, request);
    }


}
