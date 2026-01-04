package com.deber11.ejercicio1.repository;

import com.deber11.ejercicio1.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Repository
public class LibroRepository {
    private List <Libro> libros = new ArrayList<>();

    public LibroRepository() {
        libros.add(new Libro(1, "123", "Java Básico", "Juan Pérez", "2020", true));
        libros.add(new Libro(2, "456", "Spring Boot", "Ana López", "2022", true));
    }

    public List <Libro> obtenerTodosLibros(){
        return libros;
    }

    public Libro buscar(int id){
        for (Libro l : libros){
            if (l.getId() == id) {
                return l;
            }
        }
        System.out.println("No existe el libro buscado");
        return null;
    }

    public List<Libro> buscarPorAutor(String autor,String anio) {
        List<Libro> resultado = new ArrayList<>();
        for (Libro l : libros) {
            if (anio == null) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    resultado.add(l);
                }
            } else {
                if (l.getAutor().equalsIgnoreCase(autor) && l.getAnioPublicacion().equals(anio)) {
                    resultado.add(l);
                }
            }
        }
        return resultado;
    }

    public Libro agregar(Libro libro){
        libros.add(libro);
        return libro;
    }
}
