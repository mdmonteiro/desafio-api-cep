package com.desafioapicep.cepservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class HistoricoConsulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cep;
	private String tipoLogradouro;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;

	private LocalDateTime timestamp;

}
