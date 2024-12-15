package com.example.playlistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class CancionController {

    @Autowired
    private CancionService cancionService;

    // Crear una nueva canción en una Playlist
    @PostMapping("/playlist/{playlistId}")
    public ResponseEntity<Cancion> crearCancion(@PathVariable Long playlistId, @RequestBody Cancion cancion) {
        try {
            Cancion nuevaCancion = cancionService.crearCancion(playlistId, cancion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Obtener una canción por título
    @GetMapping("/{titulo}")
    public ResponseEntity<Cancion> obtenerCancionPorTitulo(@PathVariable String titulo) {
        Optional<Cancion> cancion = cancionService.obtenerCancionPorTitulo(titulo);
        if (cancion.isPresent()) {
            return ResponseEntity.ok(cancion.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
