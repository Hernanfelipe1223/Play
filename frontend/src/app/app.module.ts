import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { AppComponent } from './app.component';  <-- ELIMINA ESTA LÍNEA

@NgModule({
    declarations: [
        // AppComponent  <-- ELIMINA ESTA LÍNEA
    ],
    imports: [
        BrowserModule,
    ],
    providers: [],
    bootstrap: []  // No necesitas declarar AppComponent aquí si es standalone
})
export class AppModule { }
