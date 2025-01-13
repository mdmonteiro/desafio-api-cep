package com.desafioapicep.cepservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.desafioapicep.cepservice.dto.CepResponse;

@FeignClient(name = "cepClient", url = "http://mockoon-service:3001")
public interface CepClient {
	
    @GetMapping("/cep/{cep}")
    CepResponse buscarCep(@PathVariable("cep") String cep);
}
