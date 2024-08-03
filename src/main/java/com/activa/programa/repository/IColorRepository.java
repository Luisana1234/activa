package com.activa.programa.repository;

import com.activa.programa.model.ColorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepository extends JpaRepository<ColorModel, Long>{
    
}
