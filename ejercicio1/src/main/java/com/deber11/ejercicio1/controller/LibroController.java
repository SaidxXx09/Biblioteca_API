package com.deber11.ejercicio1.controller;

import com.deber11.ejercicio1.model.Libro;
import com.deber11.ejercicio1.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroRepository repository;

    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }



    @GetMapping ("{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable int id){
        Libro libro = repository.buscar(id);
        if (libro == null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(libro);
        }
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLibros() {
        return ResponseEntity.ok(repository.obtenerTodosLibros());
    }

    @GetMapping ("/buscar")
    public ResponseEntity<List<Libro>> buscarLibros(@RequestParam String autor, @RequestParam(required = false) String anio){
        List <Libro> libros = repository.buscarPorAutor(autor, anio);
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    public ResponseEntity<Libro> agregar(@RequestBody Libro libro){
        Libro libro1 = repository.agregar(libro);
        return ResponseEntity.status(201).body(libro1);
    }

}
