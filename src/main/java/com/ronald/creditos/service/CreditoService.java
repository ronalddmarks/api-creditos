package com.ronald.creditos.service;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.model.Credito;
import com.ronald.creditos.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    public CreditoDTO buscarCreditoPorNumero(String numeroCredito) {
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new RuntimeException("Crédito não encontrado"));

        return CreditoDTO.fromEntity(credito);
    }

    public List<CreditoDTO> buscarCreditosPorNumeroNfse(String numeroNfse) {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(numeroNfse);

        return creditos.stream().map(CreditoDTO::fromEntity).collect(Collectors.toList());
    }
}
