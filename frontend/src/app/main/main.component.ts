// src/app/main/main.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-main',  // Este es el nombre de la etiqueta HTML que usaremos en el app.component.html
  standalone: true,  // Declaramos que este componente es standalone
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  title = 'Mi Aplicación Angular';
  message = '¡Bienvenido a mi app!';
}
