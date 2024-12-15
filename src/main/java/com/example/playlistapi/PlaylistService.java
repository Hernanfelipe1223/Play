package com.example.playlistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Playlist crearPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public List<Playlist> obtenerTodasPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist obtenerPlaylistPorNombre(String nombre) {
        return playlistRepository.findByNombre(nombre);
    }

    public boolean eliminarPlaylist(String nombre) {
        Playlist playlist = playlistRepository.findByNombre(nombre);
        if (playlist != null) {
            playlistRepository.delete(playlist);
            return true;
        }
        return false;
    }
}
