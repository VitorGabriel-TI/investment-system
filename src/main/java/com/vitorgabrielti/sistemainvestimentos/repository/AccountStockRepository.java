package com.vitorgabrielti.sistemainvestimentos.repository;

import com.vitorgabrielti.sistemainvestimentos.entity.AccountStock;
import com.vitorgabrielti.sistemainvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {
}
