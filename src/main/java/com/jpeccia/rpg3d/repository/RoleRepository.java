package com.jpeccia.rpg3d.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpeccia.rpg3d.model.Role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}