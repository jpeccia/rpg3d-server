package com.jpeccia.rpg3d.dto;

import java.util.List;

public record UserRequestDTO(
    String username,
    String password,
    List<Long> roleIds
) {}
