package com.company.controllers;

import com.company.entities.Bind;

import com.company.repositories.interfaces.IBindRepo;


public class BindController {
    private final IBindRepo repo;

    public BindController(IBindRepo repo) {
        this.repo = repo;
    }
    public String enterMedicamentToOrder(int order_id,int med_id) {
        Bind bind = new Bind( order_id, med_id);
        boolean created = repo.createBind(bind);
        return (created ? "Medicament was entered into order!" : "Failed!");
    }
}
