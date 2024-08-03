package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.FabricModel;

@Repository
public interface IFabricRepository extends JpaRepository<FabricModel, Long> {

}
