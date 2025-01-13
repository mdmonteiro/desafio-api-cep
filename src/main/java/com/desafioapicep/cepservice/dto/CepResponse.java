package com.desafioapicep.cepservice.dto;

import lombok.Data;

@Data
public class CepResponse {
	private String cep;
	private String tipoLogradouro;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String error;
}