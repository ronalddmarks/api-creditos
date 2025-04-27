package com.ronald.creditos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.model.Credito;
import com.ronald.creditos.repository.CreditoRepository;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;

    public CreditoDTO buscarCreditoPorNumero(String numeroCredito) {
        Optional<Credito> creditoOptional = creditoRepository.findByNumeroCredito(numeroCredito);

        if (creditoOptional.isPresent()) {
            Credito credito = creditoOptional.get();
            CreditoDTO dto = new CreditoDTO();
            dto.setId(credito.getId());
            dto.setNumeroCredito(credito.getNumeroCredito());
            dto.setValorFaturado(credito.getValorFaturado());
            return dto;
        }
        return null; // ou lançar uma Exception personalizada
    }
}
