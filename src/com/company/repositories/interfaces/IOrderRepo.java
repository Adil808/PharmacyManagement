package com.company.repositories.interfaces;

import com.company.entities.Medicament;
import com.company.entities.Order;


import java.util.List;

public interface IOrderRepo {
    boolean createOrder(Order order);
    Order getOrderById(int id);
    List<Medicament> getMedicamentsByOrder(int id);
    List<Order> getAllOrders();
    boolean UpdateOrderById(int id);
}
