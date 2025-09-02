package com.qcrecetas.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_receta;

    @Column(name = "nombre")
    private String nombre;
    
    @CollectionTable(
        name = "receta_ingredientes",
        joinColumns =  @JoinColumn(name = "id_receta")
    )
    @ElementCollection
    @Column(name = "ingrediente")
    private List<String> ingredientes;

    @Column(name = "preparacion")
    private String preparacion;

    @CollectionTable(
        name = "receta_etiquetas",
        joinColumns =  @JoinColumn(name = "id_receta")
        
    )
    @ElementCollection
    @Enumerated(EnumType.STRING) 
    @Column(name = "etiqueta")
    private List<EtiquetaEnum> etiquetas;

    @Column(name = "tiempo")
    private Integer tiempo;

    @Column(name = "likes")
    private Integer likes = 0;

    public Integer getLikes() {
        return likes;
    }

    public Integer getIdReceta() {
        return id_receta;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public List<EtiquetaEnum> getEtiquetas() {
        return etiquetas;
    }

    public void agregarLike() {
        this.likes = this.likes + 1;
    }

    
}