package com.example.sufa.dto;

import com.example.sufa.entity.Stock;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Slice;

public class StockDto {

    private List<Stock> stocks = new ArrayList<>();

    public StockDto(Slice<Stock> stocks) {
        stocks.stream().collect(Collectors.toList());
    }
}
