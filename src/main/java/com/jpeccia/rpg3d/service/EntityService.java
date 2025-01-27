package com.jpeccia.rpg3d.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.rpg3d.dto.EntityRequestDTO;
import com.jpeccia.rpg3d.dto.EntityResponseDTO;
import com.jpeccia.rpg3d.exceptions.ResourceNotFoundException;
import com.jpeccia.rpg3d.model.Entity.Entity;
import com.jpeccia.rpg3d.repository.EntityRepository;

@Service
public class EntityService {

    @Autowired
    private EntityRepository entityRepository;

    // Cria uma nova entidade
    public EntityResponseDTO createEntity(EntityRequestDTO entityRequest) {
        Entity entity = new Entity();
        entity.setName(entityRequest.name());
        entity.setPositionX(entityRequest.positionX());
        entity.setPositionY(entityRequest.positionY());
        entity.setPositionZ(entityRequest.positionZ());
        entity.setModelUrl(entityRequest.modelUrl());

        Entity savedEntity = entityRepository.save(entity);
        return new EntityResponseDTO(
            savedEntity.getId(),
            savedEntity.getName(),
            savedEntity.getPositionX(),
            savedEntity.getPositionY(),
            savedEntity.getPositionZ(),
            savedEntity.getModelUrl()
        );
    }

    // Atualiza uma entidade existente
    public EntityResponseDTO updateEntity(Long id, EntityRequestDTO entityRequest) {
        Entity entity = entityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found with id: " + id));

        entity.setName(entityRequest.name());
        entity.setPositionX(entityRequest.positionX());
        entity.setPositionY(entityRequest.positionY());
        entity.setPositionZ(entityRequest.positionZ());
        entity.setModelUrl(entityRequest.modelUrl());

        Entity updatedEntity = entityRepository.save(entity);
        return new EntityResponseDTO(
            updatedEntity.getId(),
            updatedEntity.getName(),
            updatedEntity.getPositionX(),
            updatedEntity.getPositionY(),
            updatedEntity.getPositionZ(),
            updatedEntity.getModelUrl()
        );
    }

    // Deleta uma entidade
    public void deleteEntity(Long id) {
        Entity entity = entityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found with id: " + id));
        entityRepository.delete(entity);
    }

    // Busca uma entidade por ID
    public EntityResponseDTO getEntityById(Long id) {
        Entity entity = entityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found with id: " + id));
        return new EntityResponseDTO(
            entity.getId(),
            entity.getName(),
            entity.getPositionX(),
            entity.getPositionY(),
            entity.getPositionZ(),
            entity.getModelUrl()
        );
    }

    // Lista todas as entidades
    public List<EntityResponseDTO> getAllEntities() {
        return entityRepository.findAll().stream()
                .map(entity -> new EntityResponseDTO(
                    entity.getId(),
                    entity.getName(),
                    entity.getPositionX(),
                    entity.getPositionY(),
                    entity.getPositionZ(),
                    entity.getModelUrl()
                ))
                .collect(Collectors.toList());
    }
}