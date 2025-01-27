package com.jpeccia.rpg3d.dto;

public record CharacterRequestDTO(
    String name,
    double positionX,
    double positionY,
    double positionZ,
    String modelUrl
) {}