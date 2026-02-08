package com.example.as4.service;

import com.example.as4.model.dto.GuitarDTO;
import java.util.List;

public interface GuitarService {
    GuitarDTO create(GuitarDTO dto);
    GuitarDTO getById(Long id);
    List<GuitarDTO> getAll();
    GuitarDTO update(Long id, GuitarDTO dto);
    void delete(Long id);
}
