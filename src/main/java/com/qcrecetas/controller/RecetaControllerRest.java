package com.qcrecetas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qcrecetas.model.Receta;
import com.qcrecetas.service.RecetaService;

@RestController
public class RecetaControllerRest {

    private final RecetaService recetaService;

    public RecetaControllerRest(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    //@ApiResponse(responseCode = "200")
    //@ApiResponse(responseCode = "400", content = @Content)
    @GetMapping("/getAll")
    public ResponseEntity<List<Receta>> getAllRecetas() {
        var response = recetaService.getAllRecetas();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/getBySearch")
    public ResponseEntity<List<Receta>> getRecetasSearch(@RequestParam String keyword) {
        var response = recetaService.findBySegmentName(keyword);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/giveLike")
    public ResponseEntity<String> giveLikeRecetas(@RequestParam Integer id_receta){
        recetaService.giveLikeToReceta(id_receta);
        return ResponseEntity.ok("Success");
    }
}
