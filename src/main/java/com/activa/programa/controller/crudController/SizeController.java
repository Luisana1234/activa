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

import com.activa.programa.model.SizeModel;
import com.activa.programa.service.crudService.SizeService;

import lombok.RequiredArgsConstructor;

 @Controller
 @RequestMapping("/api/size")
 @RequiredArgsConstructor
public class SizeController {
    private final SizeService sizeService;
    
    @GetMapping("/addSize")
    public String showaaddSizes() {
        return "admin/addFormulary/addSizes";
    }

   @GetMapping()
   public String getAllSizes(Model model) {
       List<SizeModel> sizes = sizeService.getAllSizes();
       model.addAttribute("sizes", sizes);
       return "admin/Sizes";
   }

    @GetMapping("/{id}")
    public ResponseEntity<SizeModel> getSizeById(@PathVariable("id") Long id) {
        SizeModel size = sizeService.getSizeById(id);
        if (size == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<SizeModel> createSize(@RequestBody SizeModel size) {
        SizeModel createdSize = sizeService.createSize(size);
        return new ResponseEntity<>(createdSize, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SizeModel> updateSize(@PathVariable("id") Long id, @RequestBody SizeModel size) {
        SizeModel updatedSize = sizeService.updateSize(id, size);
        if (updatedSize == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedSize, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSize(@PathVariable("id") Long id) {
        sizeService.deleteSize(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
