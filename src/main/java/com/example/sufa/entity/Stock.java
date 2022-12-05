package com.example.sufa.entity;

import com.example.sufa.dto.FinanceDto;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Stock {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String explanation;
    private Integer price;
    private Integer versus;
    private LocalDate date;
    private String fluctuation;

    public void update(FinanceDto financeDto) {
        price = financeDto.getPrice();
        versus = financeDto.getVs();
        date = financeDto.getDate();
        fluctuation = financeDto.getFluctuation();
    }
}
