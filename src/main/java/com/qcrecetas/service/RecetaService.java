package com.qcrecetas.service;

import java.util.List;

import com.qcrecetas.model.Receta;

public interface RecetaService {

    List<Receta> getAllRecetas();

    List<Receta> findBySegmentName(String claveBusqueda);

    void giveLikeToReceta(Integer id);
}
