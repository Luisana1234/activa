package com.activa.programa.controller.crudController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activa.programa.model.MeasureModel;
import com.activa.programa.service.crudService.MeasureService;

@Controller
@RequestMapping("/api/measure")
@RequiredArgsConstructor
public class MeasureController {
    private final MeasureService measureService;




    @GetMapping("/addMeasurement")
    public String showaaddMeasurement() {
        return "admin/addFormulary/addMeasurement";
    }

    @GetMapping()
    public String getAllMeasures(Model model) {
        List<MeasureModel> measures = measureService.getAllMeasure();
        model.addAttribute("measures", measures);
        return "admin/Measurement";
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasureModel> getMeasureById(@PathVariable("id") Long id) {
        MeasureModel measure = measureService.getMeasureById(id);
        if (measure == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(measure, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MeasureModel> createMeasure(@RequestBody MeasureModel measure) {
        MeasureModel createdMeasure = measureService.createMeasure(measure);
        return new ResponseEntity<>(createdMeasure, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasureModel> updateMeasure(@PathVariable("id") Long id, @RequestBody MeasureModel measure) {
        MeasureModel updatedMeasure = measureService.updateMeasure(id, measure);
        if (updatedMeasure == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMeasure, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMeasure(@PathVariable("id") Long id) {
        measureService.deleteMeasure(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
