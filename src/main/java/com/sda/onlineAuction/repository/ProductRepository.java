package com.sda.onlineAuction.repository;

import com.sda.onlineAuction.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByEndDateTimeAfter(LocalDateTime localDateTime);

    @Query("select p from Product p where p.endDateTime < :now and p.winner is null and p.bidsList.size > 0")
    List<Product> findAllExpireWithoutWinnersAssigned(@Param("now") LocalDateTime now);

    @Query("select p from Product  p where p.winner.email = :email")
    List<Product> findByWinnerEmail(@Param("email") String email);
}
