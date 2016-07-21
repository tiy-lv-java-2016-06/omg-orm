package com.theironyard;

import javax.persistence.*;

/**
 * Created by vasantia on 7/20/16.
 */

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue
    private int id;

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

    public Purchase(Customer customer, String date, String credit_card, int cvv, String category) {

        this.customer = customer;
        this.date = date;
        this.credit_card = credit_card;
        this.cvv = cvv;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(String credit_card) {
        this.credit_card = credit_card;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
