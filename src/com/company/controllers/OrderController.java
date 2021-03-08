package com.company.controllers;


import com.company.entities.Medicament;
import com.company.entities.Order;


import com.company.repositories.interfaces.IMedicamentRepo;
import com.company.repositories.interfaces.IOrderRepo;


import java.util.List;

public class OrderController {
    private final IOrderRepo repo;
    private final IMedicamentRepo repo1;

    public OrderController(IOrderRepo repo, IMedicamentRepo repo1) {
        this.repo = repo;
        this.repo1 = repo1;
    }


    public String createOrder(String name, int cost) {
        Order order = new Order( name, cost);
        boolean created = repo.createOrder(order);
        return (created ? "Oreder created" : "Fail");
    }


    public String getOrder(int id) {
        Order order = repo.getOrderById(id);
        return (order == null ? "Not founded" : order.toString());
    }

    public String getMedicamentsByCompany(int id) {
        List<Medicament> medicamentList = repo.getMedicamentsByOrder(id);
        return (medicamentList == null ? "Not founded" : medicamentList.toString());
    }

    public String getAllOrders() {
        List<Order> orders = repo.getAllOrders();
        return orders.toString();
    }
    public String UpdateOrderById(int id) {
        boolean created = repo.UpdateOrderById(id);
        return (created ? "Updated" : "Fail");
    }
}
