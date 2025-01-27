package com.jpeccia.rpg3d.dto;

public record EntityRequestDTO(
    String name,
    double positionX,
    double positionY,
    double positionZ,
    String modelUrl
) {}