package com.example.sufa.repository;


import com.example.sufa.entity.Stock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StockRepository extends JpaRepository<Stock,Integer> {

    Slice<Stock> findByOrderById(Pageable pageable);
}
