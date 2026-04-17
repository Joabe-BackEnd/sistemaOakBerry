package com.piratasmall.oakberry.sistema.inventario.service;

import com.piratasmall.oakberry.sistema.inventario.model.Inventario;
import com.piratasmall.oakberry.sistema.inventario.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public Inventario mostrarInventario(){

    }

}
