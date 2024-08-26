package com.testetrabalho.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testetrabalho.Model.AbastecimentoModel;



@Repository
public interface AbastecimentosRepository extends JpaRepository <AbastecimentoModel,Long  >{

    public List<AbastecimentoModel> findAll();

 

}
