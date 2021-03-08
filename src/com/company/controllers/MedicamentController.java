package com.company.controllers;

import com.company.entities.Medicament;
import com.company.repositories.interfaces.IMedicamentRepo;


import java.util.List;

public class MedicamentController {
    private final IMedicamentRepo repo;

    public MedicamentController(IMedicamentRepo repo) {
        this.repo = repo;
    }

    public String createMedicament( String name,int cost,String description) {

        Medicament medicament = new Medicament(name,cost,description);

        boolean created = repo.createMedicament(medicament);

        return (created ? "Medicament was included to database" : "Failed!");
    }

    public String getMedicament(int id) {
        Medicament medicament = repo.getMedicamentById(id);

        return (medicament== null ? "Not founded!" : medicament.toString());
    }

    public String getAllMedicaments() {
        List<Medicament> medicamentList = repo.getAllMedicaments();

        return medicamentList.toString();
    }
}
