package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.OrderModel;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Long>{
    
}
