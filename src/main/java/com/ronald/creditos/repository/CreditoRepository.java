package com.ronald.creditos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronald.creditos.model.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Long> {
	Optional<Credito> findByNumeroCredito(String numeroCredito);
}
