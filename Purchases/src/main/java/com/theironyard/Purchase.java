package com.theironyard;

import javax.persistence.*;
/**
 * Created by Nigel on 7/20/16.
 */
@Entity
@Table(name = "purchases")
public class Purchase {

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String credit_card;

    @Column(nullable = false)
    private int cvv;

    @Column(nullable = false)
    private String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(String date, String credit_card, int cvv, String category, Customer customer) {
        this.date = date;
        this.credit_card = credit_card;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }


    public String getDate() {
        return date;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCategory() {
        return category;
    }

    public Customer getCustomer() {
        return customer;
    }
}
