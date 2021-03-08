package com.company.entities;

public class Bind {
    private int id;
    private int order_id;
    private int med_id;

    public Bind(){}
    public Bind(int id,int order_id,int med_id){
        setId(id);
        setMed_id(med_id);
        setOrder_id(order_id);
    }
    public Bind(int order_id,int med_id){
        setMed_id(med_id);
        setOrder_id(order_id);
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getMed_id() {
        return med_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public String toString(){
        return " Binding id [ id= "+getId()+" , Order id= "+getOrder_id()+" , Medicament id= "+getMed_id()+"] ";
    }
}
