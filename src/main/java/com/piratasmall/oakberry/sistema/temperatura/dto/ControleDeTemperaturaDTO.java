package com.piratasmall.oakberry.sistema.temperatura.dto;

import com.piratasmall.oakberry.sistema.temperatura.model.Temperaturas;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ControleDeTemperaturaDTO(
        Long id,
        @NotNull
        LocalDate data,
        @NotNull
        List<Temperaturas> temperaturas) {
}
