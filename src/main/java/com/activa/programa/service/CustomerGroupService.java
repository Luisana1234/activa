package com.activa.programa.service;

import com.activa.programa.model.CustomerGroupModel;
import com.activa.programa.model.CustomerModel;
import com.activa.programa.model.GroupModel;
import com.activa.programa.repository.ICustomerGroupRepository;
import com.activa.programa.repository.ICustomerRepository;
import com.activa.programa.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerGroupService {

    @Autowired
    private ICustomerGroupRepository customerGroupRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IGroupRepository groupRepository;

    // Crear un nuevo registro de CustomerGroupModel
    public CustomerGroupModel createCustomerGroup(CustomerGroupModel customerGroup) {
        // Validar las referencias a las tablas padre
        validateReferences(customerGroup);
        return customerGroupRepository.save(customerGroup);
    }

    // Actualizar un registro existente de CustomerGroupModel
    public CustomerGroupModel updateCustomerGroup(Long id, CustomerGroupModel customerGroupDetails) {
        Optional<CustomerGroupModel> customerGroupOptional = customerGroupRepository.findById(id);
        if (customerGroupOptional.isPresent()) {
            CustomerGroupModel existingCustomerGroup = customerGroupOptional.get();

            // Validar las referencias a las tablas padre
            validateReferences(customerGroupDetails);

            existingCustomerGroup.setCustomerModel(customerGroupDetails.getCustomerModel());
            existingCustomerGroup.setGroupModel(customerGroupDetails.getGroupModel());

            return customerGroupRepository.save(existingCustomerGroup);
        } else {
            throw new RuntimeException("CustomerGroupModel not found with id: " + id);
        }
    }

    // Eliminar un registro de CustomerGroupModel
    public void deleteCustomerGroup(Long id) {
        customerGroupRepository.deleteById(id);
    }

    // Obtener un registro de CustomerGroupModel por ID
    public Optional<CustomerGroupModel> getCustomerGroupById(Long id) {
        return customerGroupRepository.findById(id);
    }

    // Obtener todos los registros de CustomerGroupModel
    public List<CustomerGroupModel> getAllCustomerGroups() {
        return customerGroupRepository.findAll();
    }

    // Validar que las referencias a las tablas padre existen
    private void validateReferences(CustomerGroupModel customerGroup) {
        if (customerGroup.getCustomerModel() != null) {
            if (!customerRepository.existsById(customerGroup.getCustomerModel().getId())) {
                throw new RuntimeException("CustomerModel not found with id: " + customerGroup.getCustomerModel().getId());
            }
        }

        if (customerGroup.getGroupModel() != null) {
            if (!groupRepository.existsById(customerGroup.getGroupModel().getId())) {
                throw new RuntimeException("GroupModel not found with id: " + customerGroup.getGroupModel().getId());
            }
        }
    }
}

