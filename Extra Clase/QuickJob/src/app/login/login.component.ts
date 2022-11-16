import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from '../modelos/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public ingreso = false;
  formularioInicio!: FormGroup;
  public mostrarMensaje = false;
  public mensaje: string = '';

  constructor(private usuarioServicio: UsuarioService, private readonly formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.inicializarFormulario();
  }

  inicializarFormulario() {
    this.formularioInicio = this.formBuilder.group({
      correo: ['', [Validators.required]],
      contraseña: ['', [Validators.required]]
    });
  }

  redirigirAOpciones() {

    if (this.formularioInicio.invalid) {
      return;
    }

    let usuario: Usuario = new Usuario();

    usuario.email = this.formularioInicio.value.correo;
    usuario.password = this.formularioInicio.value.contraseña;

    this.usuarioServicio.ingresarUsuario(usuario)
      .toPromise()
      .then((usuario => {
        this.ingreso = true;
      })).catch(error => {
        this.mostrarMensaje = true;
        this.mensaje = error.error.messages[0].content;
      });
  }
}
