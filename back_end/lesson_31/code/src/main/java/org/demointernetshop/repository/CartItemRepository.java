package org.demointernetshop.repository;

import org.demointernetshop.model.entity.cart.Cart;
import org.demointernetshop.model.entity.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    @Modifying
    @Query("DELETE FROM CartItem ci WHERE ci.cart = :cart")
    public void deleteByCart(Cart cart);
}
