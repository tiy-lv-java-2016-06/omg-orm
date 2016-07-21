package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by EddyJ on 7/20/16.
 */
public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    Customer findById(Integer customer_id);
}
