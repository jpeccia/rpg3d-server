package com.jpeccia.rpg3d.dto;

import java.util.List;

public record SessionRequestDTO(
    String name,
    String description,
    Long scenarioId,
    List<Long> userIds
) {}