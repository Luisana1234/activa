package com.activa.programa.controller.crudController;

import com.activa.programa.model.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.activa.programa.model.ColorModel;
import com.activa.programa.service.crudService.ColorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller
@RequestMapping("/api/color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;
    @GetMapping("/addColor")
    public String showaaddColors() {
        return "admin/addFormulary/addColor";
    }
    @GetMapping
    public String getAllColors(Model model) {
        List<ColorModel> colors = colorService.getAllColors();
        model.addAttribute("colors", colors);
        return "admin/Color";
    }
    @GetMapping("/{id}")
    public ResponseEntity<ColorModel> getColorById(@PathVariable("id") Long id) {
        ColorModel color = colorService.getColorById(id);
        if (color == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ColorModel> createColor(@RequestBody ColorModel color) {
        ColorModel createdColor = colorService.createColor(color);
        return new ResponseEntity<>(createdColor, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ColorModel> updateColor(@PathVariable("id") Long id, @RequestBody ColorModel color) {
        ColorModel updatedColor = colorService.updateColor(id, color);
        if (updatedColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedColor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteColor(@PathVariable("id") Long id) {
        colorService.deleteColor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}