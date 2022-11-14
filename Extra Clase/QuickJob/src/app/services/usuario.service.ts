import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IdentificationType } from '../modelos/identificationType';
import { Usuario } from '../modelos/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {


  private urlTipoIdentificacion = 'http://localhost/8040/'
  private urlguardarUsuario = 'http://localhost/8040/'
  constructor(private http: HttpClient) { }

  obtenerTipoIdentificacion(): Observable<IdentificationType[]> {
    return this.http.get<IdentificationType[]>(this.urlTipoIdentificacion);
  }

  guardarUsuario(usuario: Usuario): Observable<void> {
    return this.http.post<void>(this.urlguardarUsuario, usuario);
  }
}

