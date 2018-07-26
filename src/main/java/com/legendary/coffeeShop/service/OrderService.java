package com.legendary.coffeeShop.service;

import com.legendary.coffeeShop.controller.form.OrderForm;
import com.legendary.coffeeShop.dao.entities.Order;
import com.legendary.coffeeShop.dao.entities.OrderStatus;
import com.legendary.coffeeShop.dao.entities.User;
import com.legendary.coffeeShop.dao.repositories.OrderRepository;
import com.legendary.coffeeShop.dao.repositories.UserRepository;
import com.legendary.coffeeShop.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private UserRepository userRepository;

    public Order getOrder(String username){
        User user = userRepository.findByUsername(username);
        // check if there is an open order
        Order order = orderRepository.findByUserAndOrderStatus(user, OrderStatus.IN_PROGRESS);
        if (order != null) {
            return order;
        }
        order = prepareOrder(new Order(), user);
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders(String username) {
        return orderRepository.findByUser(userRepository.findByUsername(username));
    }

    public Status updateOrder(int id, List<OrderForm> ordersForm){
        Order order = orderRepository.findById(id);
        if (order == null)
            return new Status(Status.ERROR, String.format("Could not find order with id %d", id));

        for (OrderForm orderForm: ordersForm) {
            order.setOrderItems(null);
        }
        return new Status(Status.OK, "Order updated successfully");
    }

    private Order prepareOrder(Order order, User user) {
        order.setUser(user);
        order.setCreationTime(new Timestamp(System.currentTimeMillis()));
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        order.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return order;
    }
}