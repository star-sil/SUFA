package com.example.sufa.service;

import com.example.sufa.entity.Stock;
import com.example.sufa.repository.StockRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepo;

    public List<Stock> findBySlice(int page, int size) {

        List<Stock> stocks = stockRepo.findByOrderById(PageRequest.of(page, size))
                .stream().collect(Collectors.toList());

        return stocks;
    }
}
