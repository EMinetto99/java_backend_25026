package com.talentoTech.articulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentoTech.articulos.model.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}