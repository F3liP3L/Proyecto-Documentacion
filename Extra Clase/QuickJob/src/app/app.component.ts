import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'QuickJob';
  
  public conocenos = false;
  public registrarse = false;
  public iniciarSesion = false;



  redirigirAConocenos() {
    this.conocenos = true;
  }

  redirigirARegistrarse() {
    this.registrarse = true;
  }

  redirigirAIniciarSesion() {
    this.iniciarSesion = true;
  }
}


