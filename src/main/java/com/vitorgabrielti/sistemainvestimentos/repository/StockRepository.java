package com.vitorgabrielti.sistemainvestimentos.repository;

import com.vitorgabrielti.sistemainvestimentos.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, String> {
}
