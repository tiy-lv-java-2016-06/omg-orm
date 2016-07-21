package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by vasantia on 7/20/16.
 */

@Controller
public class PurchasesController {

    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init(){

        if(customers.count() < 1) {

            File customerFile = new File("customers.csv");
            Scanner scanner;
            try {
                scanner = new Scanner(customerFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
            scanner.hasNext();
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");

                Customer customer = new Customer(lineSplit[1], lineSplit[2]);
                customers.save(customer);
            }
        }
        if(purchases.count() < 1) {
            File purchaseFile = new File("purchases.csv");
            Scanner scanner1;
            try {
                scanner1 = new Scanner(purchaseFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
            scanner1.hasNext();
            while (scanner1.hasNextLine()) {
                String[] lineSplit = scanner1.nextLine().split(",");

                Integer customer_id = null;
                Customer customer = customers.findById(customer_id);
                Integer cvv;

                try {
                    customer_id = Integer.parseInt(lineSplit[0]);
                    cvv = Integer.parseInt(lineSplit[3]);
                } catch (NumberFormatException e) {
                    continue;
                }

                Purchase purchase = new Purchase(customer, lineSplit[1], lineSplit[2], cvv, lineSplit[4]);
                purchases.save(purchase);
            }
        }

    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){

        return "home";
    }

}
