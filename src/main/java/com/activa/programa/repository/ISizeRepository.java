package com.activa.programa.repository;

import com.activa.programa.model.SizeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISizeRepository extends JpaRepository<SizeModel, Long> {
}
