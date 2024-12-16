// src/main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';  // Importamos el componente principal

bootstrapApplication(AppComponent)  // Arrancamos la aplicación con AppComponent
    .catch(err => console.error(err));  // Manejamos errores si los hay
