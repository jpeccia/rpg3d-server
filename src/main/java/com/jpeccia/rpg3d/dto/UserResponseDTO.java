package com.jpeccia.rpg3d.dto;

import java.util.List;

import com.jpeccia.rpg3d.model.Role.Role;

public record UserResponseDTO(
    Long id,
    String username,
    List<Role> roles
) {}
