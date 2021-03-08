package com.company.entities;

import java.util.List;

public class Order {
    private int id;
    private String name;
    private int cost;

    private List<Medicament> medicamentList;

    public Order(){}
    public Order(String name,int cost){
        setName(name);
        setCost(cost);

    }
    public Order(int id,String name,int cost){
        setId(id);
        setName(name);
        setCost(cost);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Medicament> getMedicamentList() {
        return medicamentList;
    }

    public void setMedicamentList(List<Medicament> medicamentList) {
        this.medicamentList = medicamentList;
    }

    @Override
    public String toString(){
        return " Order[ id= "+getId()+" ,name= "+getName()+" ,cost= "+getCost()+"] ";
    }
}
