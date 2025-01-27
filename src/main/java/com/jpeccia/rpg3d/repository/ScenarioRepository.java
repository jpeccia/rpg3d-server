package com.jpeccia.rpg3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpeccia.rpg3d.model.Scenario.Scenario;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
}