package com.testetrabalho.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testetrabalho.Model.VeiculoModel;


@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, String>{
 public List<VeiculoModel> findAll();

}
