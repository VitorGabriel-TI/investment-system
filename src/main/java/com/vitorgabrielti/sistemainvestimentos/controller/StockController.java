package com.vitorgabrielti.sistemainvestimentos.controller;

import com.vitorgabrielti.sistemainvestimentos.dto.CreateStockDTO;
import com.vitorgabrielti.sistemainvestimentos.entity.Stock;
import com.vitorgabrielti.sistemainvestimentos.entity.User;
import com.vitorgabrielti.sistemainvestimentos.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<User> createStock(@RequestBody CreateStockDTO createStockDTO) {
        stockService.createStock(createStockDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Stock>> listStocks() {
        var stocks = stockService.listStocks();
        return ResponseEntity.ok(stocks);
    }
}
