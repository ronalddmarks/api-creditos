package com.ronald.creditos.service;

import com.ronald.creditos.DTO.CreditoDTO;
import com.ronald.creditos.model.Credito;
import com.ronald.creditos.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditoServiceTest {

    @Mock
    private CreditoRepository creditoRepository;

    @InjectMocks
    private CreditoService creditoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBuscarCreditoPorNumero_Sucesso() {

        Credito credito = criarCredito();
        when(creditoRepository.findByNumeroCredito("123456")).thenReturn(Optional.of(credito));


        CreditoDTO result = creditoService.buscarCreditoPorNumero("123456");


        assertNotNull(result);
        assertEquals("123456", result.getNumeroCredito());
        verify(creditoRepository, times(1)).findByNumeroCredito("123456");
    }

    @Test
    void testBuscarCreditoPorNumero_NaoEncontrado() {

        when(creditoRepository.findByNumeroCredito("999999")).thenReturn(Optional.empty());


        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            creditoService.buscarCreditoPorNumero("999999");
        });

        assertEquals("Crédito não encontrado", exception.getMessage());
        verify(creditoRepository, times(1)).findByNumeroCredito("999999");
    }

    @Test
    void testBuscarCreditosPorNumeroNfse_Sucesso() {

        Credito credito1 = criarCredito();
        Credito credito2 = criarCredito();
        credito2.setNumeroCredito("789012");

        when(creditoRepository.findByNumeroNfse("7891011")).thenReturn(Arrays.asList(credito1, credito2));


        List<CreditoDTO> resultados = creditoService.buscarCreditosPorNumeroNfse("7891011");


        assertNotNull(resultados);
        assertEquals(2, resultados.size());
        assertEquals("123456", resultados.get(0).getNumeroCredito());
        assertEquals("789012", resultados.get(1).getNumeroCredito());
        verify(creditoRepository, times(1)).findByNumeroNfse("7891011");
    }

    private Credito criarCredito() {
        Credito credito = new Credito();
        credito.setId(1L);
        credito.setNumeroCredito("123456");
        credito.setNumeroNfse("7891011");
        credito.setDataConstituicao(LocalDate.now());
        credito.setValorIssqn(new BigDecimal("1500.75"));
        credito.setTipoCredito("AAAAA");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal("5.0"));
        credito.setValorFaturado(new BigDecimal("30000.00"));
        credito.setValorDeducao(new BigDecimal("5000.00"));
        credito.setBaseCalculo(new BigDecimal("25000.00"));
        return credito;
    }
}
