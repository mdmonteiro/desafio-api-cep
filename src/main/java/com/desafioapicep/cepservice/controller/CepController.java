package com.desafioapicep.cepservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapicep.cepservice.dto.CepResponse;
import com.desafioapicep.cepservice.service.CepService;

@RestController
@RequestMapping("/api/v1/cep")
public class CepController {
	
    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable("cep") String cep) {
        CepResponse response = cepService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }
}