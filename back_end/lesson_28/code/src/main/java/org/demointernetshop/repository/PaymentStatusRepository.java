package org.demointernetshop.repository;

import org.demointernetshop.entity.PaymentMethod;
import org.demointernetshop.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Integer> {
}
