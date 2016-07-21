package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nigel on 7/20/16.
 */

@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init(){
        if (customers.count() < 1){
            Scanner scanner;
            File customerFile = new File("customers.csv");
            try {
                scanner = new Scanner(customerFile);
            } catch (FileNotFoundException e){
                e.printStackTrace();
                return;
            }

            scanner.nextLine();
            while (scanner.hasNextLine()){
                String[] lineSplit = scanner.nextLine().split(",");
                Customer customer = new Customer(lineSplit[0], lineSplit[1]);
                customers.save(customer);
                //System.out.printf("%s - %s\n", customer.getName(), customer.getEmail());
            }
        }

        if (purchases.count() < 1) {
            Scanner scanner;
            File purchaseFile = new File("purchases.csv");
            try {
                scanner = new Scanner(purchaseFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }

            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] lineSplit = scanner.nextLine().split(",");
                int linkId = Integer.valueOf(lineSplit[0]);
                Purchase purchase = new Purchase(lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], customers.findOne(linkId));
                purchases.save(purchase);
                //System.out.printf("%s - %s - %s - %s - %s\n", purchase.getDate(), purchase.getCreditCard(), purchase.getCvv(), purchase.getCategory(), purchase.getCustomer().getName());
            }
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
        public String home(Model model, HttpSession session, HttpServletRequest request, String category){
            List<Purchase> purchaseList;
            category = request.getParameter("category");

            if (category != null) {
                purchaseList = purchases.findByCategory(category);
            }else{
                 purchaseList = purchases.findAll();
            }
                model.addAttribute("purchases", purchaseList);
            return "home";
        }
}
