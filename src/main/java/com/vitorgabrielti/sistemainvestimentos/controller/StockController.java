package com.vitorgabrielti.sistemainvestimentos.controller;

import com.vitorgabrielti.sistemainvestimentos.dto.CreateStockDTO;
import com.vitorgabrielti.sistemainvestimentos.entity.User;
import com.vitorgabrielti.sistemainvestimentos.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
