package com.activa.programa.repository;

import com.activa.programa.model.LineTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILineTypeRepository extends JpaRepository<LineTypeModel, Long> {

}