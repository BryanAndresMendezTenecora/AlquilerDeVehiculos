import { Component, OnInit } from '@angular/core';
import { ServicepersonaService } from 'src/app/services/servicepersona.service';

@Component({
  selector: 'app-listarpersona',
  templateUrl: './listarpersona.component.html',
  styleUrls: ['./listarpersona.component.scss']
})
export class ListarpersonaComponent implements OnInit {
  personas:any;
  constructor(private personasService:ServicepersonaService) { }

  ngOnInit(): void {
    this.personas=this.personasService.getPersonas();
  }

}