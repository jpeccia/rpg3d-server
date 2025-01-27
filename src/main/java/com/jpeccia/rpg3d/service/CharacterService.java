package com.jpeccia.rpg3d.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.rpg3d.repository.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    // Cria um novo personagem
    public CharacterResponseDTO createCharacter(CharacterRequestDTO characterRequest) {
        Character character = new Character();
        character.setName(characterRequest.getName());
        character.setPositionX(characterRequest.getPositionX());
        character.setPositionY(characterRequest.getPositionY());
        character.setPositionZ(characterRequest.getPositionZ());
        character.setModelUrl(characterRequest.getModelUrl());

        Character savedCharacter = characterRepository.save(character);
        return convertToDTO(savedCharacter);
    }

    // Atualiza um personagem existente
    public CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO characterRequest) {
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));

        character.setName(characterRequest.getName());
        character.setPositionX(characterRequest.getPositionX());
        character.setPositionY(characterRequest.getPositionY());
        character.setPositionZ(characterRequest.getPositionZ());
        character.setModelUrl(characterRequest.getModelUrl());

        Character updatedCharacter = characterRepository.save(character);
        return convertToDTO(updatedCharacter);
    }

    // Deleta um personagem
    public void deleteCharacter(Long id) {
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));
        characterRepository.delete(character);
    }

    // Busca um personagem por ID
    public CharacterResponseDTO getCharacterById(Long id) {
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Character not found with id: " + id));
        return convertToDTO(character);
    }

    // Lista todos os personagens
    public List<CharacterResponseDTO> getAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characters.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Converte a entidade Character para DTO
    private CharacterResponseDTO convertToDTO(Character character) {
        CharacterResponseDTO dto = new CharacterResponseDTO();
        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setPositionX(character.getPositionX());
        dto.setPositionY(character.getPositionY());
        dto.setPositionZ(character.getPositionZ());
        dto.setModelUrl(character.getModelUrl());
        return dto;
    }
}