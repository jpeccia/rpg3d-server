package com.jpeccia.rpg3d.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.rpg3d.dto.CharacterRequestDTO;
import com.jpeccia.rpg3d.dto.CharacterResponseDTO;
import com.jpeccia.rpg3d.exceptions.ResourceNotFoundException;
import com.jpeccia.rpg3d.model.Character.Characters;
import com.jpeccia.rpg3d.repository.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    // Cria um novo personagem
    public CharacterResponseDTO createCharacter(CharacterRequestDTO characterRequest) {
        Characters character = new Characters();
        character.setName(characterRequest.name());
        character.setPosX(characterRequest.positionX());
        character.setPosY(characterRequest.positionY());
        character.setPosZ(characterRequest.positionZ());
        character.setModelUrl(characterRequest.modelUrl());

        Characters savedCharacter = characterRepository.save(character);
        return new CharacterResponseDTO(
            savedCharacter.getId(),
            savedCharacter.getName(),
            savedCharacter.getPosX(),
            savedCharacter.getPosY(),
            savedCharacter.getPosZ(),
            savedCharacter.getModelUrl()
        );
    }

    // Atualiza um personagem existente
    public CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO characterRequest) {
        Characters character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));

        character.setName(characterRequest.name());
        character.setPosX(characterRequest.positionX());
        character.setPosY(characterRequest.positionY());
        character.setPosZ(characterRequest.positionZ());
        character.setModelUrl(characterRequest.modelUrl());

        Characters updatedCharacter = characterRepository.save(character);
        return new CharacterResponseDTO(
            updatedCharacter.getId(),
            updatedCharacter.getName(),
            updatedCharacter.getPosX(),
            updatedCharacter.getPosY(),
            updatedCharacter.getPosZ(),
            updatedCharacter.getModelUrl()
        );
    }

    // Deleta um personagem
    public void deleteCharacter(Long id) {
        Characters character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));
        characterRepository.delete(character);
    }

    // Busca um personagem por ID
    public CharacterResponseDTO getCharacterById(Long id) {
        Characters character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));
        return new CharacterResponseDTO(
            character.getId(),
            character.getName(),
            character.getPosX(),
            character.getPosY(),
            character.getPosZ(),
            character.getModelUrl()
        );
    }

    // Lista todos os personagens
    public List<CharacterResponseDTO> getAllCharacters() {
        return characterRepository.findAll().stream()
                .map(character -> new CharacterResponseDTO(
                    character.getId(),
                    character.getName(),
                    character.getPosX(),
                    character.getPosY(),
                    character.getPosZ(),
                    character.getModelUrl()
                ))
                .collect(Collectors.toList());
    }
}