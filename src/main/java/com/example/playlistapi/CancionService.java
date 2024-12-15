package com.example.playlistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    @Autowired
    private CancionRepository cancionRepository;

    @Autowired
    private PlaylistRepository playlistRepository;

    // Crear una nueva canción y agregarla a una playlist
    public Cancion crearCancion(Long playlistId, Cancion cancion) {
        // Verificar si la Playlist existe
        Playlist playlist = playlistRepository.findById(playlistId).orElse(null);
        if (playlist == null) {
            throw new IllegalArgumentException("Playlist no encontrada.");
        }

        // Guardar la canción en la base de datos
        Cancion nuevaCancion = cancionRepository.save(cancion);

        // Asociar la canción a la playlist
        playlist.getCanciones().add(nuevaCancion);
        playlistRepository.save(playlist);  // Guardamos la playlist con la nueva canción asociada

        return nuevaCancion;
    }

    // Obtener una canción por su título
    public Optional<Cancion> obtenerCancionPorTitulo(String titulo) {
        return Optional.ofNullable(cancionRepository.findByTitulo(titulo));
    }

    // Obtener todas las canciones (opcional)
    public List<Cancion> obtenerTodasCanciones() {
        return cancionRepository.findAll();
    }

    // Eliminar una canción por su título
    public boolean eliminarCancion(Long cancionId) {
        Optional<Cancion> cancionOptional = cancionRepository.findById(cancionId);
        if (cancionOptional.isPresent()) {
            Cancion cancion = cancionOptional.get();
            cancionRepository.delete(cancion);
            return true;
        }
        return false;
    }
}
