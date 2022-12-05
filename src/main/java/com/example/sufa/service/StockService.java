package com.example.sufa.service;

import com.example.sufa.FinanceApi;
import com.example.sufa.entity.Stock;
import com.example.sufa.repository.StockRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepo;
    private final FinanceApi financeApi;

    public List<Stock> findBySlice(int page, int size) {

        List<Stock> stocks = stockRepo.findByOrderById(PageRequest.of(page, size))
                .stream().collect(Collectors.toList());

        return stocks;
    }

    @Transactional  @Scheduled(cron = "0 0 8 * * *")
    public void updateStock() {

        List<Stock> stocks = stockRepo.findAll();

        for (Stock stock : stocks) {
            financeApi.updateStock(stock);
        }
    }
}
