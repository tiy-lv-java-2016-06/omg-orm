package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vasantia on 7/20/16.
 */
public interface CustomerRepository extends JpaRepository {

    Customer findById(int customer_id);
}
