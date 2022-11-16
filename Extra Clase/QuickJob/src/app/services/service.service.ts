import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../modelos/categoria';
import { Subcategoria } from '../modelos/subcategoria';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private urlCategoria = 'http://localhost:8080/api/service/serviceType';
  private urlSubcategoria = 'http://localhost:8080/api/service/subServiceType'

  constructor(private http: HttpClient) { }

  obtenerCategoria(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.urlCategoria);
  }

  obtenerSubcategoria(serviceType: string): Observable<Subcategoria[]> {
    return this.http.get<Subcategoria[]>(`${this.urlSubcategoria}/${serviceType}`);
  }
}
