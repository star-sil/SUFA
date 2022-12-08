package com.example.sufa.repository;

import com.example.sufa.entity.Document;
import com.example.sufa.entity.Stock;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DocumentRepository extends JpaRepository<Document,Integer> {

    Slice<Document> findByStock(Stock stock, Pageable pageable);
}
