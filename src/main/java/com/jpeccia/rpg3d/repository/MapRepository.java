package com.jpeccia.rpg3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpeccia.rpg3d.model.Map.Map;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {
}