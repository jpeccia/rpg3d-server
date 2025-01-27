package com.jpeccia.rpg3d.dto;

import java.util.List;

import com.jpeccia.rpg3d.model.Scenario.Scenario;
import com.jpeccia.rpg3d.model.User.User;

public record SessionResponseDTO(
    Long id,
    String name,
    String description,
    Scenario scenario,
    List<User> users
) {}