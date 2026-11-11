package com.example.APact3_t4.service;

import com.example.APact3_t4.entity.Autor;
import com.example.APact3_t4.entity.Libro;
import com.example.APact3_t4.repository.AutorRepository;
import com.example.APact3_t4.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    public Libro buscarPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado: " + id));
    }

    public Libro crear(Libro libro) {
        libro.setId(null);
        asignarAutor(libro);
        return libroRepository.save(libro);
    }

    public Libro actualizar(Long id, Libro datos) {
        Libro existente = buscarPorId(id);
        existente.setTitulo(datos.getTitulo());
        existente.setAutor(datos.getAutor());
        asignarAutor(existente);
        return libroRepository.save(existente);
    }

    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }

    // Busca el autor completo en la BD para que el JSON devuelva su nombre
    private void asignarAutor(Libro libro) {
        if (libro.getAutor() != null && libro.getAutor().getId() != null) {
            Autor autor = autorRepository.findById(libro.getAutor().getId())
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
            libro.setAutor(autor);
        }
    }
}