package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.activa.programa.model.CustomerGroupModel;

@Repository
public interface ICustomerGroupRepository extends JpaRepository<CustomerGroupModel, Long>{

    
}
