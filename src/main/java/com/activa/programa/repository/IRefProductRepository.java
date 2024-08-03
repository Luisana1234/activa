package com.activa.programa.repository;

import com.activa.programa.model.RefProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRefProductRepository extends JpaRepository<RefProductModel, Long> {
}