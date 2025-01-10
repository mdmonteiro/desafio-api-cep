package com.desafioapicep.cepservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.desafioapicep.cepservice.client.CepClient;
import com.desafioapicep.cepservice.dto.CepResponse;
import com.desafioapicep.cepservice.entity.HistoricoConsulta;
import com.desafioapicep.cepservice.repository.HistoricoConsultaLogRepository;

@Service
public class CepService {
	private final CepClient cepClient;
	private final HistoricoConsultaLogRepository historicoConsultaLogRepository;

	public CepService(CepClient cepClient, HistoricoConsultaLogRepository historicoConsultaLogRepository) {
		this.cepClient = cepClient;
		this.historicoConsultaLogRepository = historicoConsultaLogRepository;
	}

	public CepResponse buscarCep(String cep) {
		CepResponse cepResponse = cepClient.buscarCep(tratarCaracteresDiferentesNumero(cep));
		salvarLog(cepResponse);
		return cepResponse;
	}

	private void salvarLog(CepResponse cepResponse) {

		HistoricoConsulta log = new HistoricoConsulta();
		log.setCep(cepResponse.getCep());
		log.setTipoLogradouro(cepResponse.getTipoLogradouro());
		log.setLogradouro(cepResponse.getLogradouro());
		log.setBairro(cepResponse.getBairro());
		log.setCidade(cepResponse.getCidade());
		log.setEstado(cepResponse.getEstado());
		log.setTimestamp(LocalDateTime.now());

		historicoConsultaLogRepository.save(log);

	}

	private String tratarCaracteresDiferentesNumero(String cep) {
		return cep.replaceAll("[^\\d]", "");
	}
}
