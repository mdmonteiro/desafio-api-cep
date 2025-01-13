package com.desafioapicep.cepservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioapicep.cepservice.dto.CepResponse;
import com.desafioapicep.cepservice.exception.ExternalApiException;

@FeignClient(name = "cepClient", url = "http://mockoon-service:3001")
public interface CepClient {

	@GetMapping("/cep/{cep}")
	CepResponse getCepResponse(@PathVariable("cep") String cep);

	@GetMapping("/cep/{cep}")
	default CepResponse buscarCep(@PathVariable("cep") String cep) {
		CepResponse response = this.getCepResponse(cep);
		errorValidate(response);

		return response;

	}

	private void errorValidate(CepResponse response) {
		if (response.getError() != null) {
			throw new ExternalApiException("Erro da API externa: " + response.getError());
		}
	}
}
