package com.piratasmall.oakberry.sistema.inventario.repository;

import com.piratasmall.oakberry.sistema.inventario.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario,Integer> {

    @Query("SELECT i FROM Inventario i JOIN FETCH i.itens WHERE i.id = :id")
    Optional<Inventario> buscarComItens(@Param("id") Long id);
}
