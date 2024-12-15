package com.example.playlistapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    Cancion findByTitulo(String titulo);  // Buscar una canción por su título
}
