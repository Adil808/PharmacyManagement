package com.company.entities;

public class Medicament {
    private int id;
    private String name;
    private int cost;
    private String description;
    public Medicament(){}
    public Medicament(String name,int cost,String description){
        setName(name);
        setCost(cost);
        setDescription(description);
    }
    public Medicament(int id,String name,int cost,String description){
        setId(id);
        setName(name);
        setCost(cost);
        setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return " Medicament[ id= "+getId()+" ,name= "+getName()+" ,cost= "+getCost()+" description="+getDescription()+"] ";
    }
}
