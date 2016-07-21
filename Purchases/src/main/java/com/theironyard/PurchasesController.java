package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
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
                System.out.format("",customer);
            }
        }
    }
}
