package com.vitorgabrielti.sistemainvestimentos.service;

import com.vitorgabrielti.sistemainvestimentos.dto.CreateStockDTO;
import com.vitorgabrielti.sistemainvestimentos.entity.Stock;
import com.vitorgabrielti.sistemainvestimentos.entity.User;
import com.vitorgabrielti.sistemainvestimentos.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public void createStock(CreateStockDTO createStockDTO) {

        var stock = new Stock(
                createStockDTO.stockId(),
                createStockDTO.description()
        );

        stockRepository.save(stock);
    }

    public List<Stock> listStocks() {
        return stockRepository.findAll();
    }
}
