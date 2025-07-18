package com.talentoTech.articulos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentoTech.articulos.model.Articulo;
import com.talentoTech.articulos.service.ArticuloService;

@RestController

// Define la ruta
// http://localhost:8080/api/articulos

@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    // Contructor del Controlador que recibe un objeto del tipo Servicio para la "injeción de dependencia"
    public ArticuloController(ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    // Mostrar articulos
    // api/articulos
    @GetMapping
    public List<Articulo> listarArticulos(){
        return articuloService.listarArticulos();
    }

    // Mostrar articulo
    // api/articulos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerArticuloPorId(@PathVariable Long id){
        return articuloService.obtenerArticuloPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // Crear articulo
    // api/articulos
    @PostMapping
    public ResponseEntity<Articulo> crearArticulo(@RequestBody Articulo articulo){
        return ResponseEntity.ok(articuloService.crearArticulo(articulo));    // Respuesta 201
    }

    // Modificar articulo
    // api/articulos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Articulo> modificarArticulo(@PathVariable Long id, @RequestBody Articulo articulo){
        // Si el articulo no existe (petición de articulo es vacia)
        if (articuloService.obtenerArticuloPorId(id).isEmpty()){
            // Entonces la respuesta es No se encontró
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloService.modificarArticulo(id, articulo)); // Se encontró. Petición OK
    }

    // Eliminar articulo
    // api/articulos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Long id){
        if (articuloService.obtenerArticuloPorId(id).isEmpty()){
            // Entonces la respuesta es No se encontró
            return ResponseEntity.notFound().build(); // No se encontró. 404 Not found
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build(); // Se encontró. Se elimina, Petición 204 NO CONTENT
    }
}