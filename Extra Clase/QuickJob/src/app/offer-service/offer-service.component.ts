import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../modelos/categoria';
import { Servicio } from '../modelos/servicio';
import { Subcategoria } from '../modelos/subcategoria';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-offer-service',
  templateUrl: './offer-service.component.html',
  styleUrls: ['./offer-service.component.css']
})
export class OfferServiceComponent implements OnInit {

  @Output()
  emitir = new EventEmitter<any>();

  private readonly MENSAJE_EXITO = 'Se guardó exitosamente';
  public categorias: Categoria[] = [];
  public subcategorias: Subcategoria[] = [];
  public mostrarMensajeExito = false;
  public mostrarMensajeError = false;
  public mensajeExito = '';
  public mensajeError = '';


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
      categoria: ['', [Validators.required]],
      subcategoria: ['', [Validators.required]],
      servicio: ['', [Validators.required]],
      descripcion: ['', [Validators.required]],

    });
  }

  cargarSubcategorias() {
    this.subcategorias = [];
    if (!!this.formularioServicio.value.categoria) {
      this.service.obtenerSubcategoria(this.formularioServicio.value.categoria).subscribe(subcategoria => {
        this.subcategorias = subcategoria;
      });
    }
  }

  regresar() {
    this.emitir.emit(false);
  }


  publicarServicio() {

    if (this.formularioServicio.invalid) {
      return;
    }

    let servicio: Servicio = new Servicio();
    let subcategoria: Subcategoria = new Subcategoria();

    servicio.name = this.formularioServicio.value.servicio;
    servicio.description = this.formularioServicio.value.descripcion;
    servicio.state = true;

    subcategoria.id = this.formularioServicio.value.subcategoria;
    servicio.subService = subcategoria;

    this.service.guardarServicio(servicio)
      .toPromise()
      .then(servicio => {
        this.mostrarMensajeExito = true;
        this.mensajeExito = this.MENSAJE_EXITO
      }).catch(error => {
        this.mostrarMensajeError = true;
        this.mensajeError = error.error.messages[0].content;;
      });
  }

}
