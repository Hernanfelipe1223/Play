// src/app/app.component.ts
import { Component } from '@angular/core';
import { MainComponent } from './main/main.component';  // Importa el MainComponent

@Component({
  selector: 'app-root',  // Esta es la etiqueta que se usará en el archivo index.html
  standalone: true,  // Marcamos este componente como standalone
  template: `<app-main></app-main>`,  // Usamos el componente MainComponent en el template
  styleUrls: ['./app.component.css'],
  imports: [MainComponent]  // Importamos el MainComponent para que sea usado en este componente
})
export class AppComponent {
  // Este componente solo sirve para alojar el MainComponent en su template
}
