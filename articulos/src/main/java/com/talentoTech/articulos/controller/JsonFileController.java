package com.talentoTech.articulos.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentoTech.articulos.model.Articulo;

@Component
public class JsonFileController {
    private ObjectMapper mapper = new ObjectMapper();
    private final File archivoJSON = new File("articulos.json");

    public void writeJSON(List<Articulo> articulos){
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivoJSON, articulos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //public update

    //public remove
}