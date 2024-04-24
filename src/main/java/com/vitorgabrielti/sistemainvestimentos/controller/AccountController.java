package com.vitorgabrielti.sistemainvestimentos.controller;

import com.vitorgabrielti.sistemainvestimentos.dto.AccountStockDTO;
import com.vitorgabrielti.sistemainvestimentos.dto.AccountStockResponseDTO;
import com.vitorgabrielti.sistemainvestimentos.entity.User;
import com.vitorgabrielti.sistemainvestimentos.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<User> associateStock(@PathVariable("accountId") String accountId,
                                               @RequestBody AccountStockDTO accountStockDTO) {

        accountService.associateStock(accountId, accountStockDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDTO>> associateStock(@PathVariable("accountId") String accountId) {

        var stocks = accountService.listStocks(accountId);

        return ResponseEntity.ok(stocks);
    }
}
