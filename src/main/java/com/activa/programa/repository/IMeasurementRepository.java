package com.activa.programa.repository;

import com.activa.programa.model.MeasureModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeasurementRepository extends JpaRepository<MeasureModel, Long> {
}
