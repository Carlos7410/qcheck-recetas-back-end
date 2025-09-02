package com.qcrecetas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qcrecetas.model.Receta;

@Repository
public interface RecetaRepository extends CrudRepository<Receta, Integer>{

    @Query("SELECT r " +
           "FROM Receta r " +
           "WHERE r.nombre LIKE CONCAT ('%', :keyword, '%')")
    List<Receta> getRecetasBySearch(@Param("keyword") String keyword);
    
}
