package com.example.sufa.dto;

import com.google.gson.JsonElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class FinanceDto {

    private Integer price;
    private Integer vs;
    private LocalDate date;
    private String fluctuation;

    public FinanceDto(JsonElement element) {
        price = element.getAsJsonObject().get("clpr").getAsInt();
        vs = element.getAsJsonObject().get("vs").getAsInt();
        fluctuation = element.getAsJsonObject().get("fltRt").getAsString();
        date = LocalDate.parse(element.getAsJsonObject().get("basDt").getAsString(),
                DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
