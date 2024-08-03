package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.CustomerModel;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerModel, Long> {

}