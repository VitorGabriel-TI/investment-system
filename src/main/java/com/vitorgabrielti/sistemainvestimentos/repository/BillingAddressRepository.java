package com.vitorgabrielti.sistemainvestimentos.repository;

import com.vitorgabrielti.sistemainvestimentos.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingAddressRepository extends JpaRepository <BillingAddress, UUID>{
}
