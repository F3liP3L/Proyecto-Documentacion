import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public ingreso = false;

  constructor() { }

  ngOnInit(): void {
  }

  redirigirAOpciones() {
    this.ingreso = true;
  }

}
