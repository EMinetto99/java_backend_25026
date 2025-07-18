package com.talentoTech.articulos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    public Articulo(){};

    public Articulo(Long id, String nombre, Double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getID(){
        return this.id;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Double getPrecio(){
        return this.precio;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPrecio(Double precio){
        this.precio = precio;
    }
}