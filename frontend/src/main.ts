import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';  // Importas tu componente principal

// Arrancas la aplicación utilizando el componente standalone
bootstrapApplication(AppComponent)
  .catch(err => console.error(err));
