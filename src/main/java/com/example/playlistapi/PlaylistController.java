package com.example.playlistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Playlist> crearPlaylist(@RequestBody Playlist playlist) {
        if (playlist.getNombre() == null || playlist.getNombre().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Playlist nuevaPlaylist = playlistService.crearPlaylist(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPlaylist);
    }

    @GetMapping
    public List<Playlist> obtenerTodasPlaylists() {
        return playlistService.obtenerTodasPlaylists();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Playlist> obtenerPlaylistPorNombre(@PathVariable String nombre) {
        Playlist playlist = playlistService.obtenerPlaylistPorNombre(nombre);
        if (playlist == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(playlist);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminarPlaylist(@PathVariable String nombre) {
        if (!playlistService.eliminarPlaylist(nombre)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
