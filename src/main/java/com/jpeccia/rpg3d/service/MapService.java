package com.jpeccia.rpg3d.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpeccia.rpg3d.dto.MapRequestDTO;
import com.jpeccia.rpg3d.dto.MapResponseDTO;
import com.jpeccia.rpg3d.exceptions.ResourceNotFoundException;
import com.jpeccia.rpg3d.model.Map.Map;
import com.jpeccia.rpg3d.repository.MapRepository;

@Service
public class MapService {

    @Autowired
    private MapRepository mapRepository;

    // Cria um novo mapa
    public MapResponseDTO createMap(MapRequestDTO mapRequest) {
        Map map = new Map();
        map.setName(mapRequest.name());

        Map savedMap = mapRepository.save(map);
        return new MapResponseDTO(
            savedMap.getId(),
            savedMap.getName()
        );
    }

    // Atualiza um mapa existente
    public MapResponseDTO updateMap(Long id, MapRequestDTO mapRequest) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Map not found with id: " + id));

        map.setName(mapRequest.name());

        Map updatedMap = mapRepository.save(map);
        return new MapResponseDTO(
            updatedMap.getId(),
            updatedMap.getName()
        );
    }

    // Deleta um mapa
    public void deleteMap(Long id) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Map not found with id: " + id));
        mapRepository.delete(map);
    }

    // Busca um mapa por ID
    public MapResponseDTO getMapById(Long id) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Map not found with id: " + id));
        return new MapResponseDTO(
            map.getId(),
            map.getName()
        );
    }

    // Lista todos os mapas
    public List<MapResponseDTO> getAllMaps() {
        return mapRepository.findAll().stream()
                .map(map -> new MapResponseDTO(
                    map.getId(),
                    map.getName()
                ))
                .collect(Collectors.toList());
    }
}