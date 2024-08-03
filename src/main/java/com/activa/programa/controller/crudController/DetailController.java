package com.activa.programa.controller.crudController;

import com.activa.programa.model.DetailModel;
import com.activa.programa.service.crudService.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/detail")
@RequiredArgsConstructor
public class DetailController {

    private final DetailService detailService;

    @GetMapping("/addDetail")
    public String showAddDetail() {
        return "admin/addFormulary/addDetail";
    }

    @GetMapping
    public ResponseEntity<List<DetailModel>> getAllDetails() {
        List<DetailModel> details = detailService.getAllDetails();
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailModel> getDetailById(@PathVariable("id") Long id) {
        return detailService.getDetailById(id)
                .map(detail -> new ResponseEntity<>(detail, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetailModel> createDetail(@RequestBody DetailModel detail) {
        try {
            DetailModel createdDetail = detailService.createDetail(detail);
            return new ResponseEntity<>(createdDetail, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailModel> updateDetail(@PathVariable("id") Long id, @RequestBody DetailModel detailDetails) {
        try {
            DetailModel updatedDetail = detailService.updateDetail(id, detailDetails);
            return new ResponseEntity<>(updatedDetail, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDetail(@PathVariable("id") Long id) {
        try {
            detailService.deleteDetail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
