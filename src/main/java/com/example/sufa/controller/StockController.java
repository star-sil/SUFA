package com.example.sufa.controller;

import com.example.sufa.entity.Stock;
import com.example.sufa.service.StockService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping(value = "/stocks")
    public List<Stock> findBySlice(@RequestParam int page, @RequestParam int size) {
        return stockService.findBySlice(page, size);
    }
}
