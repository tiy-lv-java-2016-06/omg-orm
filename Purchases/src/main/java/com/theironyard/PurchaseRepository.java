package com.theironyard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by EddyJ on 7/20/16.
 */
public interface PurchaseRepository  extends JpaRepository <Purchase, Integer> {
    List<Purchase> findByCategory(String category);
}
