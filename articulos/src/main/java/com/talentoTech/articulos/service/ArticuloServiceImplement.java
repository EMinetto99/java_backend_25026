package com.talentoTech.articulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentoTech.articulos.model.Articulo;
import com.talentoTech.articulos.repository.ArticuloRepository;

@Service
public class ArticuloServiceImplement implements ArticuloService {
    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImplement(ArticuloRepository articuloRepository){
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo crearArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo modificarArticulo(Long id, Articulo articulo) {
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }
}