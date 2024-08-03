package com.activa.programa.controller.crudController;

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

import com.activa.programa.model.LineTypeModel;
import com.activa.programa.service.crudService.LineTypeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/api/lineType")
@RequiredArgsConstructor
public class LineTypeController {

    private final LineTypeService lineTypeService;




    @GetMapping("/addLineType")
    public String showaaddLine_Type() {
        return "admin/addFormulary/addLine_Type";
    }

    @GetMapping()
    public String getAllLineTypes(Model model) {
        List<LineTypeModel> lineTypes = lineTypeService.getAllLineTypes();
        model.addAttribute("lineTypes", lineTypes);
        return "admin/LineType";
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineTypeModel> getLineTypeById(@PathVariable("id") Long id) {
        LineTypeModel lineType = lineTypeService.getLineTypeById(id);
        if (lineType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lineType, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<LineTypeModel> createLineType(@RequestBody LineTypeModel lineType) {
        LineTypeModel createdLineType = lineTypeService.createLineType(lineType);
        return new ResponseEntity<>(createdLineType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LineTypeModel> updateLineType(@PathVariable("id") Long id, @RequestBody LineTypeModel lineType) {
        LineTypeModel updatedLineType = lineTypeService.updateLineType(id, lineType);
        if (updatedLineType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedLineType, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLineType(@PathVariable("id") Long id) {
        lineTypeService.deleteLineType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}