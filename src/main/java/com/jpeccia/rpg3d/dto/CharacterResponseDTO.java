package com.jpeccia.rpg3d.dto;

public record CharacterResponseDTO(
    Long id,
    String name,
    double positionX,
    double positionY,
    double positionZ,
    String modelUrl
) {}