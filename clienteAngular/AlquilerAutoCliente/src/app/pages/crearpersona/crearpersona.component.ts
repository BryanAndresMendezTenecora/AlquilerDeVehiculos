import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/domain/persona';

@Component({
  selector: 'app-crearpersona',
  templateUrl: './crearpersona.component.html',
  styleUrls: ['./crearpersona.component.scss']
})
export class CrearpersonaComponent implements OnInit {
  persona:Persona=new Persona();
  constructor() { }

  ngOnInit(): void {
  }
  guardar():void{
    console.log("guardadndo....")
  }

}
