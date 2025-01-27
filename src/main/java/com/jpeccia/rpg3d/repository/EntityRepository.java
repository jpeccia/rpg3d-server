package com.jpeccia.rpg3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpeccia.rpg3d.model.Entity.Entity;

@Repository
public interface EntityRepository extends JpaRepository<Entity, Long> {
}