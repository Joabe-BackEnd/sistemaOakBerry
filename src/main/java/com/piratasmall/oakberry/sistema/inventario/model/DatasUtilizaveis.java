package com.piratasmall.oakberry.sistema.inventario.model;

import java.time.LocalDate;

public record DatasUtilizaveis() {

    public LocalDate hoje(){
        return LocalDate.now();
    }

    public LocalDate ontem(){
        return hoje().minusDays(1);
    }

}
