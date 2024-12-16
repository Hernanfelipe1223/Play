// src/app/services/playlist.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// Definimos las interfaces de los datos que esperamos de la API
interface Cancion {
  titulo: string;
  artista: string;
  album: string;
  anno: string;
  genero: string;
}

interface Playlist {
  nombre: string;
  descripcion: string;
  canciones: Cancion[];
}

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  // La URL base de tu backend
  private apiUrl = 'http://localhost:8080/lists';  // Ajusta según tu configuración

  constructor(private http: HttpClient) { }

  // Obtener todas las playlists
  obtenerPlaylists(): Observable<Playlist[]> {
    return this.http.get<Playlist[]>(this.apiUrl);
  }

  // Crear una nueva playlist
  crearPlaylist(playlist: Playlist): Observable<Playlist> {
    return this.http.post<Playlist>(this.apiUrl, playlist);
  }

  // Obtener una playlist por su nombre
  obtenerPlaylistPorNombre(nombre: string): Observable<Playlist> {
    return this.http.get<Playlist>(`${this.apiUrl}/${nombre}`);
  }

  // Eliminar una playlist
  eliminarPlaylist(nombre: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${nombre}`);
  }
}
