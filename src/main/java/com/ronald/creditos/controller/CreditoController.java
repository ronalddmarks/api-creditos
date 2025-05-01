package com.ronald.creditos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.service.CreditoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @GetMapping("/credito/{numero}")
    public CreditoDTO buscarCredito(@PathVariable String numero) {
        return creditoService.buscarCreditoPorNumero(numero);
    }
    
    @GetMapping("/{numeroNfse}")
    public List<CreditoDTO> buscarCreditosPorNfse(@PathVariable String numeroNfse) {
        return creditoService.buscarCreditosPorNumeroNfse(numeroNfse);
    }
}
