package com.example.as4.controller;

import com.example.as4.model.dto.GuitarDTO;
import com.example.as4.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guitars")
public class GuitarController {

    private final GuitarService guitarService;

    @Autowired
    public GuitarController(GuitarService guitarService) {
        this.guitarService = guitarService;
    }

    @PostMapping
    public ResponseEntity<GuitarDTO> create(@RequestBody GuitarDTO dto) {
        return new ResponseEntity<>(guitarService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuitarDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(guitarService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GuitarDTO>> getAll() {
        return ResponseEntity.ok(guitarService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuitarDTO> update(@PathVariable Long id, @RequestBody GuitarDTO dto) {
        return ResponseEntity.ok(guitarService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        guitarService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
