package com.piratasmall.oakberry.sistema.temperatura.repository;

import com.piratasmall.oakberry.sistema.temperatura.model.ControleDeTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ControleDeTemperaturaRepository extends JpaRepository<ControleDeTemperatura, Long> {


    Optional<ControleDeTemperatura> findByData(LocalDate data);
}
