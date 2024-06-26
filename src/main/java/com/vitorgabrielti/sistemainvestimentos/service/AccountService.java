package com.vitorgabrielti.sistemainvestimentos.service;

import com.vitorgabrielti.sistemainvestimentos.client.BrapiClient;
import com.vitorgabrielti.sistemainvestimentos.dto.AccountStockDTO;
import com.vitorgabrielti.sistemainvestimentos.dto.AccountStockResponseDTO;
import com.vitorgabrielti.sistemainvestimentos.entity.AccountStock;
import com.vitorgabrielti.sistemainvestimentos.entity.AccountStockId;
import com.vitorgabrielti.sistemainvestimentos.repository.AccountRepository;
import com.vitorgabrielti.sistemainvestimentos.repository.AccountStockRepository;
import com.vitorgabrielti.sistemainvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Value("#{environment.BRAPITOKEN}")
    private String BRAPITOKEN;

    private StockRepository stockRepository;
    private AccountRepository accountRepository;
    private AccountStockRepository accountStockRepository;
    private BrapiClient brapiClient;

    public AccountService(StockRepository stockRepository,
                          AccountRepository accountRepository,
                          AccountStockRepository accountStockRepository,
                          BrapiClient brapiClient) {
        this.stockRepository = stockRepository;
        this.accountRepository = accountRepository;
        this.accountStockRepository = accountStockRepository;
        this.brapiClient = brapiClient;
    }

    public void associateStock(String accountId, AccountStockDTO accountStockDTO) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account nao existe"));

        var stock = stockRepository.findById(accountStockDTO.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock nao existe"));

        var id = new AccountStockId(account.getAccountId(), stock.getStockId());

        var accountStockEntity = new AccountStock(id, account, stock, accountStockDTO.quantity());

        accountStockRepository.save(accountStockEntity);
    }

    public List<AccountStockResponseDTO> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account nao existe"));

        return account.getAccountStocks()
                .stream()
                .map(ac -> new AccountStockResponseDTO(
                                ac.getStock().getStockId(),
                                ac.getQuantity(),
                                getTotal(ac.getQuantity(),
                                        ac.getStock().getStockId())
                        ))
                .toList();

    }

    private double getTotal(Integer quantity, String stockId) {

        var response = brapiClient.getQuote(BRAPITOKEN, stockId);

        var price = response.results().getFirst().regularMarketPrice();

        return quantity * price;
    }
}
