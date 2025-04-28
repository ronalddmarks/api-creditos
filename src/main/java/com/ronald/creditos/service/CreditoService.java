package com.ronald.creditos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.exception.ResourceNotFoundException;
import com.ronald.creditos.model.Credito;
import com.ronald.creditos.repository.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    public CreditoDTO buscarCreditoPorNumero(String numeroCredito) {
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new ResourceNotFoundException("Crédito não encontrado"));

        return CreditoDTO.fromEntity(credito);
    }

    public List<CreditoDTO> buscarCreditosPorNumeroNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(numeroNfse);

        return creditos.stream().map(CreditoDTO::fromEntity).collect(Collectors.toList());
    }
}
