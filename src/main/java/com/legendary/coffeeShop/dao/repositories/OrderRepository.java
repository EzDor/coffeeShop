package com.legendary.coffeeShop.dao.repositories;

import com.legendary.coffeeShop.dao.entities.order.Order;
import com.legendary.coffeeShop.dao.entities.order.OrderStatus;
import com.legendary.coffeeShop.dao.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUserAndOrderStatus(User user, OrderStatus status);
    List<Order> findAllByUserAndOrderStatus(User user, OrderStatus status);
    Order findById(int id);
}

