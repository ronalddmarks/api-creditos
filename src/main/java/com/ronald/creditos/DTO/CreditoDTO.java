package com.ronald.creditos.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ronald.creditos.model.Credito;

public class CreditoDTO {
	
    private Long id;

    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private String simplesNacional; // Sim ou Não
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCredito() {
		return numeroCredito;
	}
	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}
	public String getNumeroNfse() {
		return numeroNfse;
	}
	public void setNumeroNfse(String numeroNfse) {
		this.numeroNfse = numeroNfse;
	}
	public LocalDate getDataConstituicao() {
		return dataConstituicao;
	}
	public void setDataConstituicao(LocalDate dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}
	public BigDecimal getValorIssqn() {
		return valorIssqn;
	}
	public void setValorIssqn(BigDecimal valorIssqn) {
		this.valorIssqn = valorIssqn;
	}
	public String getTipoCredito() {
		return tipoCredito;
	}
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
	public String getSimplesNacional() {
		return simplesNacional;
	}
	public void setSimplesNacional(String simplesNacional) {
		this.simplesNacional = simplesNacional;
	}
	public BigDecimal getAliquota() {
		return aliquota;
	}
	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
	public BigDecimal getValorFaturado() {
		return valorFaturado;
	}
	public void setValorFaturado(BigDecimal valorFaturado) {
		this.valorFaturado = valorFaturado;
	}
	public BigDecimal getValorDeducao() {
		return valorDeducao;
	}
	public void setValorDeducao(BigDecimal valorDeducao) {
		this.valorDeducao = valorDeducao;
	}
	public BigDecimal getBaseCalculo() {
		return baseCalculo;
	}
	public void setBaseCalculo(BigDecimal baseCalculo) {
		this.baseCalculo = baseCalculo;
	}
	
	
	
	
	//  Conversor de Entity para DTO
    public static CreditoDTO fromEntity(Credito credito) {
        CreditoDTO dto = new CreditoDTO();
        dto.setId(credito.getId());
        dto.setNumeroCredito(credito.getNumeroCredito());
        dto.setNumeroNfse(credito.getNumeroNfse());
        dto.setDataConstituicao(credito.getDataConstituicao());
        dto.setValorIssqn(credito.getValorIssqn());
        dto.setTipoCredito(credito.getTipoCredito());
        dto.setSimplesNacional(credito.isSimplesNacional() ? "Sim" : "Não");
        dto.setAliquota(credito.getAliquota());
        dto.setValorFaturado(credito.getValorFaturado());
        dto.setValorDeducao(credito.getValorDeducao());
        dto.setBaseCalculo(credito.getBaseCalculo());
        return dto;
    }
    


  
}
