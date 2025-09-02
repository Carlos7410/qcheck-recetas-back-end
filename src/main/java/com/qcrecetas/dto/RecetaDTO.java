package com.qcrecetas.dto;

import java.util.List;

import com.qcrecetas.model.EtiquetaEnum;
import com.qcrecetas.model.Receta;

public class RecetaDTO {
    
    private String nombreReceta;
    private List<String> ingredientes;
    private String preparacion;
    private List<EtiquetaEnum> etiquetas;
    private Integer likesReceta;

    public static RecetaDTO from(Receta receta) {
        var recetaDTO = new RecetaDTO();
        recetaDTO.nombreReceta = receta.getNombre();
        recetaDTO.ingredientes = receta.getIngredientes();
        recetaDTO.preparacion = receta.getPreparacion();
        recetaDTO.etiquetas = receta.getEtiquetas();
        recetaDTO.likesReceta = receta.getLikes();
        return recetaDTO;
    }
}
