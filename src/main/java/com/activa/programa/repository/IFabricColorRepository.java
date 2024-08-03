package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.FabricColorModel;

@Repository
public interface IFabricColorRepository extends JpaRepository<FabricColorModel, Long> {

    
    
}
