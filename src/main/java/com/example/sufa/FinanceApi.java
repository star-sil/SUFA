package com.example.sufa;

import com.example.sufa.dto.FinanceDto;
import com.example.sufa.entity.Stock;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FinanceApi {

    @Value("${key.finance}")
    private String key;
    @Value("${url.finance}")
    private String baseUrl;
    private final String query = "&numOfRows=1&resultType=json&likeItmsNm=";

    public Stock updateStock(Stock stock) {

        try {
            String result = requestApi(
                baseUrl + key + query + URLEncoder.encode(stock.getName(), "UTF-8"));
            JsonElement element = JsonParser.parseString(result);

            JsonObject asJsonObject = element.getAsJsonObject().getAsJsonObject("response")
                .getAsJsonObject("body").getAsJsonObject("items");
            JsonElement item = asJsonObject.getAsJsonArray("item").get(0);
            FinanceDto financeDto = new FinanceDto(item);
            stock.update(financeDto);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return stock;
    }

    private String requestApi(String baseUrl) throws IOException {
        URL url = new URL(baseUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        return readApi(br);
    }

    private String readApi(BufferedReader br) throws IOException {
        String line = "";
        String result = "";

        while ((line = br.readLine()) != null) {
            result += line;
        }
        log.info(result);
        return result;
    }
}
