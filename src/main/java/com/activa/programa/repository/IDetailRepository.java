package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.DetailModel;

@Repository
public interface IDetailRepository extends JpaRepository<DetailModel, Long> {



}
