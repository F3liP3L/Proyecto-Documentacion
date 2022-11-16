import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../modelos/categoria';
import { Subcategoria } from '../modelos/subcategoria';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-offer-service',
  templateUrl: './offer-service.component.html',
  styleUrls: ['./offer-service.component.css']
})
export class OfferServiceComponent implements OnInit {

  public categorias: Categoria[] = [];
  public subcategorias: Subcategoria[] = [];

  formularioServicio!: FormGroup;

  constructor(private service: ServiceService, private readonly formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.inicializarFormulario();
    this.service.obtenerCategoria().subscribe(categoria => {
      this.categorias = categoria;
    });
  }

  inicializarFormulario() {
    this.formularioServicio = this.formBuilder.group({
      categoria: ['', [Validators.required]]

    });
  }

  cargarSubcategorias() {
    if (!!this.formularioServicio.value.categoria) {
      this.service.obtenerSubcategoria(this.formularioServicio.value.categoria).subscribe(subcategoria => {
        this.subcategorias = subcategoria;
      });
    }
  }

}
