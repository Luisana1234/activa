package com.activa.programa.controller.crudController;
import com.activa.programa.service.CustomerGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.activa.programa.model.CustomerGroupModel;
import java.util.Optional;
import java.util.Map;

import java.util.List;

@Controller
@RequestMapping("/api/customerGroup")
@RequiredArgsConstructor
public class CustomerGroupController {

    private final CustomerGroupService customerGroupService;



    @GetMapping("/addCustomergroup")
    public String showAddCustomer_groupPage() {
        return "admin/addFormulary/addCustomer_group";
    }

    @GetMapping
    public ResponseEntity<List<CustomerGroupModel>> getAllCustomerGroups() {
        List<CustomerGroupModel> customerGroups = customerGroupService.getAllCustomerGroups();
        return new ResponseEntity<>(customerGroups, HttpStatus.OK);
    }

    // Obtener un registro de CustomerGroupModel por ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerGroupModel> getCustomerGroupById(@PathVariable("id") Long id) {
        Optional<CustomerGroupModel> customerGroupOptional = customerGroupService.getCustomerGroupById(id);
        return customerGroupOptional
                .map(customerGroup -> new ResponseEntity<>(customerGroup, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear un nuevo registro de CustomerGroupModel
    @PostMapping
    public ResponseEntity<CustomerGroupModel> createCustomerGroup(@RequestBody CustomerGroupModel customerGroup) {
        try {
            CustomerGroupModel createdCustomerGroup = customerGroupService.createCustomerGroup(customerGroup);
            return new ResponseEntity<>(createdCustomerGroup, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Manejo de errores como referencias a tablas padre no encontradas
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Actualizar un registro existente de CustomerGroupModel
    @PutMapping("/{id}")
    public ResponseEntity<CustomerGroupModel> updateCustomerGroup(@PathVariable("id") Long id, @RequestBody CustomerGroupModel customerGroupDetails) {
        try {
            CustomerGroupModel updatedCustomerGroup = customerGroupService.updateCustomerGroup(id, customerGroupDetails);
            return new ResponseEntity<>(updatedCustomerGroup, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Manejo de errores como registro no encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un registro de CustomerGroupModel por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerGroup(@PathVariable("id") Long id) {
        try {
            customerGroupService.deleteCustomerGroup(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            // Manejo de errores como registro no encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}