package com.desafioapicep.cepservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.desafioapicep.cepservice.client.CepClient;
import com.desafioapicep.cepservice.dto.CepResponse;
import com.desafioapicep.cepservice.entity.HistoricoConsulta;
import com.desafioapicep.cepservice.exception.InvalidCepFormatException;
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
		validarCep(cep);
		CepResponse cepResponse = cepClient.buscarCep(cep);
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

	private void validarCep(String cep) {
		if (!cep.matches("\\d{8}")) {
			throw new InvalidCepFormatException("Formato de CEP inválido. Deve conter exatamente 8 números.");
		}
	}

}
