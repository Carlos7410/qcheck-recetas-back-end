package com.qcrecetas.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcrecetas.model.Receta;
import com.qcrecetas.repository.RecetaRepository;
import com.qcrecetas.service.RecetaService;

@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository recetaRepo;

    @Autowired
    public RecetaServiceImpl(RecetaRepository recetaRepo) {
        this.recetaRepo = recetaRepo;
    }

    @Override
    public List<Receta> getAllRecetas() {
        ArrayList<Receta> recetas = new ArrayList<>();
        for(Receta receta:recetaRepo.findAll()) {
            recetas.add(receta);
        }
        return recetas;
    }

    @Override
    public List<Receta> findBySegmentName(String claveBusqueda) {
        ArrayList<Receta> recetas = new ArrayList<>();
        for(Receta receta:recetaRepo.getRecetasBySearch(claveBusqueda)) {
            recetas.add(receta);
        }
        return recetas;
    }

    @Override
    public void giveLikeToReceta(Integer id_receta) {
        Receta recetaToUpdate = recetaRepo.findById(id_receta).orElseThrow(NullPointerException::new);
        recetaToUpdate.agregarLike();
        recetaRepo.save(recetaToUpdate);

    }
    
}
