package com.jpeccia.rpg3d.model.Scenario;

import java.util.List;
import java.util.Set;

import com.jpeccia.rpg3d.model.Map.Map;
import com.jpeccia.rpg3d.model.Session.Session;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Nome do cenário

    @Column(nullable = false)
    private String description; // Descrição do cenário

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "scenario_maps",
        joinColumns = @JoinColumn(name = "scenario_id"),
        inverseJoinColumns = @JoinColumn(name = "map_id")
    )
    private Set<Map> maps; // Mapas associados ao cenário

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "scenario_characters",
        joinColumns = @JoinColumn(name = "scenario_id"),
        inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<Character> characters; // Personagens dos jogadores ou NPCs

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "scenario_entities",
        joinColumns = @JoinColumn(name = "scenario_id"),
        inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    private Set<Entity> entities; // Entidades como monstros, vilões, etc.

    @Column(nullable = false)
    private double lightIntensity; // Intensidade de luz do cenário

    @Column(nullable = false)
    private String backgroundColor; // Cor de fundo do cenário (ex: cor do céu ou ambiente)

    @Column(nullable = false)
    private boolean isNight; // Indica se é de noite ou dia (impacta na iluminação, por exemplo)

    // Relacionamento com a sessão do mestre
    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session; // Sessão do mestre que está gerenciando este cenário

}
