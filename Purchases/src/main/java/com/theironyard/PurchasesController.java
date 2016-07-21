package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by EddyJ on 7/20/16.
 */
@Controller
public class PurchasesController {

    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init() throws FileNotFoundException {
        if(customers.count() < 1){
            File customerFile = new File("customers.csv");
            Scanner scanner = new Scanner(customerFile);
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String[] lineSplit = scanner.nextLine().split(",");
                Customer customer = new Customer(lineSplit[0], lineSplit[1]);
                customers.save(customer);
            }
        }
        if(purchases.count() < 1){
            File purchaseFile = new File("purchases.csv");
            Scanner scanner = new Scanner(purchaseFile);
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String[] lineSplit = scanner.nextLine().split(",");
                Integer cvv;
                cvv = Integer.parseInt(lineSplit[3]);
                Integer customer_id = Integer.parseInt(lineSplit[0]);
                Customer customer = customers.findById(customer_id);
                Purchase purchase = new Purchase(customer, lineSplit[1], lineSplit[2], cvv, lineSplit[4]);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        List<Customer> customerList;
        List<Purchase> purchaseList;
        customerList = customers.findAll();
        purchaseList = purchases.findAll();

        model.addAttribute("customers", customerList);
        model.addAttribute("purchases", purchaseList);
        return "home";
    }
}
