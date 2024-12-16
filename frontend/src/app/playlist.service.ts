import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlaylistService {

  private apiUrl = 'http://localhost:3000/lists'; // Cambia la URL a la que necesites

  constructor(private http: HttpClient) {}

  getPlaylists(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);  // Asegúrate de que la respuesta es un array de playlists
  }

}
