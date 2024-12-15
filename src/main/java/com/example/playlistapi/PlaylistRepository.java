package com.example.playlistapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Playlist findByNombre(String nombre); // Buscar una playlist por su nombre
}
