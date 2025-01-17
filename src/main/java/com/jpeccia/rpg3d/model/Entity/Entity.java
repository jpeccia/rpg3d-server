package com.jpeccia.rpg3d.model.Entity;

import com.jpeccia.rpg3d.model.Scenario.Scenario;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Nome do monstro ou vilão

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario; // Referência ao cenário onde o monstro/vilão está

    @Column(nullable = false)
    private double posX; // Posição X no cenário

    @Column(nullable = false)
    private double posY; // Posição Y no cenário

    @Column(nullable = false)
    private double posZ; // Posição Z no cenário

    @Column(nullable = false)
    private String modelUrl; // URL ou caminho para o modelo 3D do monstro/vilão

}
