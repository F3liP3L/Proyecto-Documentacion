import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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

  formularioRegistro!: FormGroup;

  constructor(private usuarioServicio: UsuarioService, private readonly formBuilder: FormBuilder,) {
  }

  ngOnInit(): void {
    this.inicializarFormulario();
    const tipo1: IdentificationType = {
      id: '1',
      name: 'Cédula'
    }
    const tipo2: IdentificationType = {
      id: '2',
      name: 'Tarjeta identidad'
    }
    this.tipoIdentificacion.push(tipo1);
    this.tipoIdentificacion.push(tipo2)
    /**this.usuarioServicio.obtenerTipoIdentificacion().subscribe(identificacion => {
      this.tipoIdentificacion = identificacion;
    });*/
  }

  inicializarFormulario() {
    this.formularioRegistro = this.formBuilder.group({
      nombre: ['', [Validators.required]],
      apellido: ['', [Validators.required]],
      identificacion: ['', [Validators.required]],
      tipoIdent: ['', [Validators.required]],
      correo: ['', [Validators.required]],
      clave: ['', [Validators.required]],
      fechaNacimiento: ['', [Validators.required]]
    });
  }

  registrarse() {

    if (this.formularioRegistro.invalid) {
      return;
    }
    let usuario: Usuario = new Usuario;
    let tipoIdentificacion = new IdentificationType;
    let documentoIdentificacion = new IdentificationpDocument;

    usuario.name = this.formularioRegistro.value.nombre;
    usuario.lastName = this.formularioRegistro.value.apellido;
    usuario.email = this.formularioRegistro.value.correo;
    tipoIdentificacion = this.formularioRegistro.value.tipoIdent;
    documentoIdentificacion.identificationptye = tipoIdentificacion;
    documentoIdentificacion.identificationNumber = this.formularioRegistro.value.identificacion;
    documentoIdentificacion.birthdate = this.formularioRegistro.value.fechaNacimiento;
    usuario.identification = documentoIdentificacion;

    this.usuarioServicio.guardarUsuario(usuario)
      .subscribe();


  }

}
