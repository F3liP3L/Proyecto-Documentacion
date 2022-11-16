import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Ciudad } from '../modelos/ciudad';
import { IdentificationpDocument } from '../modelos/identification-document';
import { IdentificationType } from '../modelos/identificationType';
import { Usuario } from '../modelos/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.css']
})
export class CheckInComponent implements OnInit {

  public tipoIdentificacion: IdentificationType[] = [];
  public ciudades: Ciudad[] = [];
  public mostrarMensaje = false;
  public mensaje: string = '';
  public mostrarOpciones = false;

  formularioRegistro!: FormGroup;

  constructor(private usuarioServicio: UsuarioService, private readonly formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.inicializarFormulario();
    this.usuarioServicio.obtenerTipoIdentificacion().subscribe(identificacion => {
      this.tipoIdentificacion = identificacion;
    });
    this.usuarioServicio.obtenerCiudad().subscribe(ciudad => {
      this.ciudades = ciudad;
    });

  }

  inicializarFormulario() {
    this.formularioRegistro = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      identificacion: ['', [Validators.required]],
      tipoIdent: [null, [Validators.required]],
      correo: ['', [Validators.required, Validators.email]],
      clave: ['', [Validators.required]],
      fechaNacimiento: ['', [Validators.required]],
      ciudad: [null, [Validators.required]],

    });
  }

  registrarse() {

    if (this.formularioRegistro.invalid) {
      return;
    }

    let usuario: Usuario = new Usuario();
    let documentoIdentificacion = new IdentificationpDocument();
    let tipoIdentificacion = new IdentificationType();
    let ciudad = new Ciudad();

    usuario.name = this.formularioRegistro.value.nombre;
    usuario.lastName = this.formularioRegistro.value.apellido;
    usuario.email = this.formularioRegistro.value.correo;
    usuario.password = this.formularioRegistro.value.clave;

    documentoIdentificacion.name = this.formularioRegistro.value.nombre;
    documentoIdentificacion.surname = this.formularioRegistro.value.apellido;
    documentoIdentificacion.birthdate = this.formularioRegistro.value.fechaNacimiento;
    documentoIdentificacion.identificationNumber = this.formularioRegistro.value.identificacion;
    tipoIdentificacion.id = this.formularioRegistro.value.tipoIdent;
    documentoIdentificacion.identificationType = tipoIdentificacion;

    usuario.identification = documentoIdentificacion;
    ciudad.id = this.formularioRegistro.value.ciudad;
    usuario.residenceCity = ciudad;
    documentoIdentificacion.placeOfBirth = ciudad;

    this.usuarioServicio.guardarUsuario(usuario)
      .toPromise()
      .then(usuario => {
        this.mostrarOpciones = true;
      }).catch(error => {
        this.mostrarMensaje = true;
        this.mensaje = error.error.messages[0].content;;

      });


  }

}
