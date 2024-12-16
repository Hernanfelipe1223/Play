import { Component } from '@angular/core';
import { PlaylistService } from './playlist.service'; // Si estás usando el PlaylistService

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Mi Aplicación Angular';
  playlists: any[] = []; // Debes declarar playlists como un array vacío o el tipo adecuado

  constructor(private playlistService: PlaylistService) {}

  ngOnInit() {
    this.playlistService.getPlaylists().subscribe(
        (data) => {
          this.playlists = data;  // Asegúrate de que 'data' es un array o lo que esperas
        },
        (error) => {
          console.error(error); // Maneja los errores
        }
    );
  }
}
