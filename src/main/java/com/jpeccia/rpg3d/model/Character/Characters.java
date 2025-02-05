package com.jpeccia.rpg3d.model.Character;

import com.jpeccia.rpg3d.model.Scenario.Scenario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Characters {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Nome do personagem

    @Column(nullable = false)
    private boolean isNPC; // Indica se é um NPC ou um personagem de jogador

    @ManyToOne
    @JoinColumn(name = "scenario_id")
    private Scenario scenario; // Referência ao cenário onde o personagem está

    @Column(nullable = false)
    private double posX; // Posição X no cenário

    @Column(nullable = false)
    private double posY; // Posição Y no cenário

    @Column(nullable = false)
    private double posZ; // Posição Z no cenário

    @Column(nullable = false)
    private String modelUrl; // URL ou caminho para o modelo 3D (ex: modelo de personagem)

}
