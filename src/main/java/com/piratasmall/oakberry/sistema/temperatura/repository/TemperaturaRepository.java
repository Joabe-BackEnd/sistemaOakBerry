package com.piratasmall.oakberry.sistema.temperatura.repository;

import com.piratasmall.oakberry.sistema.temperatura.model.Temperaturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperaturaRepository extends JpaRepository<Temperaturas,Long> {
}
