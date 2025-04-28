package com.ronald.creditos.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.service.CreditoService;

class CreditoControllerTest {

    @Mock
    private CreditoService creditoService;

    @InjectMocks
    private CreditoController creditoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarCreditoPorNumero() {

        String numeroCredito = "123456";
        CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito(numeroCredito);
        creditoDTO.setValorIssqn(BigDecimal.valueOf(1500.75));

        when(creditoService.buscarCreditoPorNumero(numeroCredito)).thenReturn(creditoDTO);

        CreditoDTO resultado = creditoController.buscarCredito(numeroCredito);

        assertNotNull(resultado);
        assertEquals(numeroCredito, resultado.getNumeroCredito());
        assertEquals(BigDecimal.valueOf(1500.75), resultado.getValorIssqn());
    }

    @Test
    void deveBuscarCreditosPorNumeroNfse() {
        String numeroNfse = "7891011";
        CreditoDTO credito1 = new CreditoDTO();
        credito1.setNumeroCredito("123456");
        credito1.setNumeroNfse(numeroNfse);

        CreditoDTO credito2 = new CreditoDTO();
        credito2.setNumeroCredito("789012");
        credito2.setNumeroNfse(numeroNfse);

        when(creditoService.buscarCreditosPorNumeroNfse(numeroNfse))
            .thenReturn(Arrays.asList(credito1, credito2));

        List<CreditoDTO> resultado = creditoController.buscarCreditosPorNfse(numeroNfse);

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("123456", resultado.get(0).getNumeroCredito());
        assertEquals("789012", resultado.get(1).getNumeroCredito());
    }
}
