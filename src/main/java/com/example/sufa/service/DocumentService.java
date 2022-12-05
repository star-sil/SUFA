package com.example.sufa.service;

import com.example.sufa.entity.Document;
import com.example.sufa.entity.Stock;
import com.example.sufa.repository.DocumentRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepo;

    public List<Document> findByStock(int page, int size, Stock stock) {
        return documentRepo.findByStock(stock, PageRequest.of(page, size))
                .stream().collect(Collectors.toList());
    }
}
