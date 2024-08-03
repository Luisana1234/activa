package com.activa.programa.service.crudService;


import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.activa.programa.model.CustomerModel;
import com.activa.programa.repository.ICustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

private final ICustomerRepository customerRepository;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerModel getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public CustomerModel createCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public CustomerModel updateCustomer(Long id, CustomerModel customerDetails) {
        CustomerModel customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }
        customer.setCustomerId(customerDetails.getCustomerId());
        customer.setCustomerName(customerDetails.getCustomerName());
        customer.setCustomerLastName(customerDetails.getCustomerLastName());
        customer.setCustomerAddress(customerDetails.getCustomerAddress());
        customer.setCustomerContact(customerDetails.getCustomerContact());
        customer.setCustomerPhone(customerDetails.getCustomerPhone());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}