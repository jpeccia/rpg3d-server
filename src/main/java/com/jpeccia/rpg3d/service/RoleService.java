package com.jpeccia.rpg3d.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.rpg3d.dto.RoleRequestDTO;
import com.jpeccia.rpg3d.dto.RoleResponseDTO;
import com.jpeccia.rpg3d.exceptions.ResourceNotFoundException;
import com.jpeccia.rpg3d.model.Role.Role;
import com.jpeccia.rpg3d.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Cria uma nova role
    public RoleResponseDTO createRole(RoleRequestDTO roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.name());

        Role savedRole = roleRepository.save(role);
        return new RoleResponseDTO(
            savedRole.getId(),
            savedRole.getName()
        );
    }

    // Atualiza uma role existente
    public RoleResponseDTO updateRole(Long id, RoleRequestDTO roleRequest) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        role.setName(roleRequest.name());

        Role updatedRole = roleRepository.save(role);
        return new RoleResponseDTO(
            updatedRole.getId(),
            updatedRole.getName()
        );
    }

    // Deleta uma role
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        roleRepository.delete(role);
    }

    // Busca uma role por ID
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        return new RoleResponseDTO(
            role.getId(),
            role.getName()
        );
    }

    // Lista todas as roles
    public List<RoleResponseDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> new RoleResponseDTO(
                    role.getId(),
                    role.getName()
                ))
                .collect(Collectors.toList());
    }
}