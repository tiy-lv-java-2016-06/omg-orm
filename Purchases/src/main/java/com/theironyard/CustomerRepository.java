package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nigel on 7/20/16.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
