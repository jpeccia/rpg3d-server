package com.jpeccia.rpg3d.dto;

import java.util.List;

import com.jpeccia.rpg3d.model.Entity.Entity;
import com.jpeccia.rpg3d.model.Map.Map;

public record ScenarioResponseDTO(
    Long id,
    String name,
    String backgroundColor,
    boolean isDay,
    List<Character> characters,
    List<Entity> entities,
    List<Map> maps
) {}