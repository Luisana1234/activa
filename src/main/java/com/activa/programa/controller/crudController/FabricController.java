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

import com.activa.programa.model.FabricModel;
import com.activa.programa.service.crudService.FabricService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/fabric")
@RequiredArgsConstructor
public class FabricController {
    
    private final FabricService fabricService;

    @GetMapping("/addFabric")
    public String showAddFabric() {
        return "admin/addFormulary/addFabric";
    }
    @GetMapping()
    public String getAllFabrics(Model model) {
        List<FabricModel> fabrics = fabricService.getAllFabric();
        model.addAttribute("fabrics", fabrics);
        return "admin/Fabric";
    }
    @GetMapping("/{id}")
    public ResponseEntity<FabricModel> getFabricById(@PathVariable("id") Long id) {
        FabricModel fabric = fabricService.getFabricById(id);
        if (fabric == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fabric, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<FabricModel> createFabric(@RequestBody FabricModel fabric) {
        FabricModel createdFabric = fabricService.createFabric(fabric);
        return new ResponseEntity<>(createdFabric, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricModel> updateFabric(@PathVariable("id") Long id, @RequestBody FabricModel fabric) {
        FabricModel updatedFabric = fabricService.updateFabric(id, fabric);
        if (updatedFabric == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFabric, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFabric(@PathVariable("id") Long id) {
        fabricService.deleteFabric(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
