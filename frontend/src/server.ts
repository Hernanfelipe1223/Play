import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import { platformBrowser } from '@angular/platform-browser';

platformBrowser().destroy();  // Destruir cualquier instancia previa de la plataforma.
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
