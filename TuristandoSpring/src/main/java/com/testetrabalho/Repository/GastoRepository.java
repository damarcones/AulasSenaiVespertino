package com.testetrabalho.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testetrabalho.Model.GastoModel;


@Repository
public interface GastoRepository extends JpaRepository<GastoModel, Long>{

 public List<GastoModel> findAll();

}
