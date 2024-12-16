import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private apiUrl = 'http://localhost:8080/lists';  // URL de la API de tu backend

  constructor(private http: HttpClient) { }

  // Obtener todas las listas de reproducción
  getAllPlaylists(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Obtener una lista de reproducción por nombre
  getPlaylistByName(name: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${name}`);
  }

  // Crear una nueva lista de reproducción
  createPlaylist(playlist: any): Observable<any> {
    return this.http.post(this.apiUrl, playlist);
  }

  // Eliminar una lista de reproducción
  deletePlaylist(name: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${name}`);
  }
}
