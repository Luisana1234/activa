package com.activa.programa.controller.crudController;
import com.activa.programa.service.crudService.FabricColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.activa.programa.model.FabricColorModel;
import java.util.Optional;
import java.util.Map;

import java.util.List;

@Controller
@RequestMapping("/api/fabriColor")
@RequiredArgsConstructor
public class FabricColorController {

    private final FabricColorService fabricColorService;

    @GetMapping
    public ResponseEntity<List<FabricColorModel>> getAllFabricColors() {
        List<FabricColorModel> fabricColors = fabricColorService.getAllFabricColors();
        return new ResponseEntity<>(fabricColors, HttpStatus.OK);
    }

    // Obtener un registro de FabricColorModel por ID
    @GetMapping("/{id}")
    public ResponseEntity<FabricColorModel> getFabricColorById(@PathVariable("id") Long id) {
        Optional<FabricColorModel> fabricColorOptional = fabricColorService.getFabricColorById(id);
        return fabricColorOptional
                .map(fabricColor -> new ResponseEntity<>(fabricColor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo registro de FabricColorModel
    @PostMapping("create")
    public ResponseEntity<FabricColorModel> createFabricColor(@RequestBody FabricColorModel fabricColor) {
        try {
            FabricColorModel createdFabricColor = fabricColorService.createFabricColor(fabricColor);
            return new ResponseEntity<>(createdFabricColor, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Manejo de errores como referencias a tablas padre no encontradas
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Actualizar un registro existente de FabricColorModel
    @PutMapping("/{id}")
    public ResponseEntity<FabricColorModel> updateFabricColor(@PathVariable("id") Long id, @RequestBody FabricColorModel fabricColorDetails) {
        try {
            FabricColorModel updatedFabricColor = fabricColorService.updateFabricColor(id, fabricColorDetails);
            return new ResponseEntity<>(updatedFabricColor, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Manejo de errores como registro no encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un registro de FabricColorModel por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFabricColor(@PathVariable("id") Long id) {
        try {
            fabricColorService.deleteFabricColor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            // Manejo de errores como registro no encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}