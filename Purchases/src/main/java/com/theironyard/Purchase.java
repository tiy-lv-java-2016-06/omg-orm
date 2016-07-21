package com.theironyard;

import javax.persistence.*;

/**
 * Created by EddyJ on 7/20/16.
 */
@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    Customer customer;

    @Column
    private String date;

    @Column
    private String creditCard;

    @Column
    private int cvv;

    @Column
    private String category;

    public Purchase() {
    }

    public Purchase(Customer customer, String date, String creditCard, int cvv, String category) {
        this.customer = customer;
        this.date = date;
        this.creditCard = creditCard;
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

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
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
