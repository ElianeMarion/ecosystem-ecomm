package br.com.fiap.postech.adjt.checkout.repository;

import br.com.fiap.postech.adjt.checkout.entity.Checkout;
import br.com.fiap.postech.adjt.checkout.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
    List<Order> findByConsumerId(UUID consumerId);
}
