package com.talentoTech.articulos.service;

import java.util.List;
import java.util.Optional;
import com.talentoTech.articulos.model.Articulo;

public interface ArticuloService {
    // Mostrar articulos
    public List<Articulo> listarArticulos();

    // Mostrar articulo
    public Optional<Articulo> obtenerArticuloPorId(Long id);

    // Crear articulo
    public Articulo crearArticulo(Articulo articulo);

    // Modificar articulo
    public Articulo modificarArticulo(Long id, Articulo articulo);

    // Eliminar articulo
    public void eliminarArticulo(Long id);
}