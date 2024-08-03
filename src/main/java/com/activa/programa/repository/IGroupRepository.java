package com.activa.programa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.activa.programa.model.GroupModel;

@Repository
public interface IGroupRepository extends JpaRepository<GroupModel, Long> {

}