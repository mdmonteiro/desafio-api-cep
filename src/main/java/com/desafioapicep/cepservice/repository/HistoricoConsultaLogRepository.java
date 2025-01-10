package com.desafioapicep.cepservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioapicep.cepservice.entity.HistoricoConsulta;

@Repository
public interface HistoricoConsultaLogRepository extends JpaRepository<HistoricoConsulta, Long> {
}