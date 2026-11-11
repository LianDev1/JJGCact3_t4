package com.example.APact3_t4.repository;

import com.example.APact3_t4.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}