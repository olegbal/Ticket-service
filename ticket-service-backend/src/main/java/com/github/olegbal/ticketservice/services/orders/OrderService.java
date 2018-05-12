package com.github.olegbal.ticketservice.services.orders;

import com.github.olegbal.ticketservice.entities.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(long id);

    Order getOrderByUserId(long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    boolean deleteOrder(long id);

    Order createOrderOfTickets(List<Long> ticketIds, Long userId);

    void removeAllOrders();
}
