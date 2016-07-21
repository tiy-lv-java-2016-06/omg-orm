package com.theironyard;

import javax.persistence.*;

/**
 * Created by vasantia on 7/20/16.
 */

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private int customer_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
