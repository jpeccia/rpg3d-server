package com.jpeccia.rpg3d.dto;

import java.util.List;

public record ScenarioRequestDTO(
    String name,
    String backgroundColor,
    boolean isDay,
    List<Long> characterIds,
    List<Long> entityIds,
    List<Long> mapIds
) {}