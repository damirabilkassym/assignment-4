package com.example.as4.service.impl;

import com.example.as4.model.dto.GuitarDTO;
import com.example.as4.model.entity.Guitar;
import com.example.as4.repository.GuitarRepository;
import com.example.as4.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuitarServiceImpl implements GuitarService {

    private final GuitarRepository guitarRepository;

    @Autowired
    public GuitarServiceImpl(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
    }

    @Override
    public GuitarDTO create(GuitarDTO dto) {
        Guitar guitar = Guitar.builder()
                .guitarName(dto.getGuitarName())
                .guitarBrand(dto.getGuitarBrand())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .build();

        guitar = guitarRepository.save(guitar);
        return mapToDTO(guitar);
    }

    @Override
    public GuitarDTO getById(Long id) {
        Guitar guitar = guitarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guitar not found"));
        return mapToDTO(guitar);
    }

    @Override
    public List<GuitarDTO> getAll() {
        return guitarRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GuitarDTO update(Long id, GuitarDTO dto) {
        Guitar guitar = guitarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guitar not found"));

        guitar.setGuitarName(dto.getGuitarName());
        guitar.setGuitarBrand(dto.getGuitarBrand());
        guitar.setStock(dto.getStock());
        guitar.setPrice(dto.getPrice());

        guitar = guitarRepository.save(guitar);
        return mapToDTO(guitar);
    }

    @Override
    public void delete(Long id) {
        Guitar guitar = guitarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guitar not found"));
        guitarRepository.delete(guitar);
    }

    private GuitarDTO mapToDTO(Guitar guitar) {
        return GuitarDTO.builder()
                .id(guitar.getId())
                .guitarName(guitar.getGuitarName())
                .guitarBrand(guitar.getGuitarBrand())
                .stock(guitar.getStock())
                .price(guitar.getPrice())
                .build();
    }
}
