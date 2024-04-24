package com.vitorgabrielti.sistemainvestimentos.repository;

import com.vitorgabrielti.sistemainvestimentos.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
