package com.piratasmall.oakberry.sistema.temperatura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperaturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "geladeira",nullable = false)
    private Double geladeira;
    @Column(name = "freezer_um",nullable = false)
    private Double freezerUm;
    @Column(name = "freezer_dois",nullable = false)
    private Double freezerDois;

    @Enumerated(EnumType.STRING)
    private ManhaOuTarde manhaOuTarde;

    @ManyToOne
    @JoinColumn(name = "controle_id")
    private ControleDeTemperatura controle;
}
