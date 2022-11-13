import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {


private urlTipoIdentificacion = 'http://localhost/8040/'
  constructor(private http : HttpClient) { }
}

obtenerTipoIdentificacion(){
  
}