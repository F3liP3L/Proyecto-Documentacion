import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-option',
  templateUrl: './option.component.html',
  styleUrls: ['./option.component.css']
})
export class OptionComponent implements OnInit {

  public ofrecerServicio = false;

  constructor() { }

  ngOnInit(): void {
  }

  redirigirAOfrecerServicios() {
    console.log('entré a ofrecer servicio');
    
    this.ofrecerServicio = true;
  }

}
