package com.piratasmall.oakberry.sistema.temperatura.dto.mapper;

import com.piratasmall.oakberry.sistema.temperatura.dto.ControleDeTemperaturaDTO;
import com.piratasmall.oakberry.sistema.temperatura.model.ControleDeTemperatura;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ControleDeTemperaturaMapper {

    ControleDeTemperatura toEntity(ControleDeTemperaturaDTO dto);

    ControleDeTemperaturaDTO toDTO(ControleDeTemperatura entity);
}
