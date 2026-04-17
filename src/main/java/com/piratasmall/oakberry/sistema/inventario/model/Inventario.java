package com.piratasmall.oakberry.sistema.inventario.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inventarios")
@EntityListeners(AuditingEntityListener.class)
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDate data;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<InventarioItens> produtos;
}
