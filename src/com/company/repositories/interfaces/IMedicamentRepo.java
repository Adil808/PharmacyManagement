package com.company.repositories.interfaces;

import com.company.entities.Medicament;

import java.util.List;

public interface IMedicamentRepo {
    boolean createMedicament(Medicament medicament);
    Medicament getMedicamentById(int id);
    List<Medicament> getAllMedicaments();
}
