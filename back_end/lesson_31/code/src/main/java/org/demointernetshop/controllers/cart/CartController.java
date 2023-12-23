package org.demointernetshop.controllers.cart;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.dto.cart.CartChangeDto;
import org.demointernetshop.model.dto.cart.CartDto;
import org.demointernetshop.services.CartService;
import org.springframework.web.bind.annotation.*;

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
