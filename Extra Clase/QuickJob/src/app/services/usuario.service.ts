import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ciudad } from '../modelos/ciudad';
import { IdentificationType } from '../modelos/identificationType';
import { Usuario } from '../modelos/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {


  private urlTipoIdentificacion = 'http://localhost:8080/api/user/identificationType';
  private urlCiudad = 'http://localhost:8080/api/user/city'
  private urlguardarUsuario = 'http://localhost:8080/api/user/'
  constructor(private http: HttpClient) { }

  obtenerTipoIdentificacion(): Observable<IdentificationType[]> {
    return this.http.get<IdentificationType[]>(this.urlTipoIdentificacion);
  }

  obtenerCiudad(): Observable<Ciudad[]> {
    return this.http.get<Ciudad[]>(this.urlCiudad);
  }

  guardarUsuario(usuario: Usuario): Observable<void> {
    return this.http.post<void>(this.urlguardarUsuario, usuario);
  }
}

