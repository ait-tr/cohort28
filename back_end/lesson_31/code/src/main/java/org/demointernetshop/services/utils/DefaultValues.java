package org.demointernetshop.services.utils;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.model.entity.OrderStatus;
import org.demointernetshop.model.entity.PaymentMethod;
import org.demointernetshop.model.entity.PaymentStatus;
import org.demointernetshop.model.entity.Role;
import org.demointernetshop.repository.OrderStatusRepository;
import org.demointernetshop.repository.PaymentMethodRepository;
import org.demointernetshop.repository.PaymentStatusRepository;
import org.demointernetshop.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultValues {

    private final RoleRepository roleRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentStatusRepository paymentStatusRepository;


    public Role getDefaultRole() {
        return roleRepository.findById(2).orElseThrow(() -> new RuntimeException("Default role not found!"));
    }

    public OrderStatus getDefaultOrderStatus() {
        return orderStatusRepository.findById(1).orElseThrow(() -> new RuntimeException("Default order status not found!"));
    }

    public PaymentMethod getDefaultPaymentMethod() {
        return paymentMethodRepository.findById(1).orElseThrow(() -> new RuntimeException("Default payment method not found!"));
    }

    public PaymentStatus getDefaultPaymentStatus() {
        return paymentStatusRepository.findById(1).orElseThrow(() -> new RuntimeException("Default payment status not found!"));
    }

}
