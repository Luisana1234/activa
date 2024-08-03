package com.activa.programa.controller.crudController;
import com.activa.programa.model.RefProductModel;
import com.activa.programa.service.RefProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.activa.programa.model.RefProductModel;

import java.util.List;

@Controller
@RequestMapping("/api/refProduct")
@RequiredArgsConstructor
public class RefProductController {

    private final RefProductService refProductService;

    @GetMapping("/addProductRef")
    public String showaaddProduct_reference() {
        return "admin/addFormulary/addProduct_reference";
    }

    @GetMapping
    public ResponseEntity<List<RefProductModel>> getAllRefProducts() {
        List<RefProductModel> refProducts = refProductService.getAllRefProducts();
        return new ResponseEntity<>(refProducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RefProductModel> getRefProductById(@PathVariable("id") Long id) {
        RefProductModel refProduct = refProductService.getRefProductById(id);
        if (refProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(refProduct, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RefProductModel> createRefProduct(@RequestBody RefProductModel refProductModel) {
        try {
            RefProductModel createdRefProduct = refProductService.createRefProduct(refProductModel);
            return new ResponseEntity<>(createdRefProduct, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefProductModel> updateRefProduct(
            @PathVariable("id") Long id,
            @RequestBody RefProductModel refProductModel) {
        try {
            RefProductModel updatedRefProduct = refProductService.updateRefProduct(id, refProductModel);
            return new ResponseEntity<>(updatedRefProduct, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRefProduct(@PathVariable("id") Long id) {
        try {
            refProductService.deleteRefProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}