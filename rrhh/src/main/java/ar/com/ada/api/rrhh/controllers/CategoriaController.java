package ar.com.ada.api.rrhh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.rrhh.entities.*;
import ar.com.ada.api.rrhh.services.CategoriaService;

@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categorias")
    public ResponseEntity<?>  crearCategoria(@RequestBody Categoria categoria) {
        categoriaService.crearCategoria(categoria);
        return ResponseEntity.ok(categoria);
    }
    
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias() {

        return  ResponseEntity.ok(categoriaService.listarCategorias());
    }
}
