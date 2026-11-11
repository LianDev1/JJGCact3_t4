package com.example.APact3_t4.controller;

import com.example.APact3_t4.entity.Autor;
import com.example.APact3_t4.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @GetMapping
    public List<Autor> listar() {
        return autorRepository.findAll();
    }
}