package com.theironyard;

import javax.persistence.*;
/**
 * Created by Nigel on 7/20/16.
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String creditCard;

    @Column(nullable = false)
    private String cvv;

    @Column(nullable = false)
    private String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(String date, String credit_card, String cvv, String category, Customer customer) {
        this.date = date;
        this.creditCard = credit_card;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }


    public String getDate() {
        return date;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getCvv() {
        return cvv;
    }

    public String getCategory() {
        return category;
    }

    public Customer getCustomer() {
        return customer;
    }
}
