package com.learningexpress.exmaple.msd.prostgresentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    private int id;
    private   int productId;

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Order() {
    }

    public Order(int id, int productId) {
        this.id = id;
        this.productId = productId;
    }
}
