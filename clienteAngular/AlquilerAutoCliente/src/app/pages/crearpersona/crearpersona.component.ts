import { Component, OnInit } from '@angular/core';

import { Persona } from 'src/app/domain/persona';
import { ServicepersonaService } from 'src/app/services/servicepersona.service';
import { NavigationExtras, Router } from '@angular/router';

@Component({
  selector: 'app-crearpersona',
  templateUrl: './crearpersona.component.html',
  styleUrls: ['./crearpersona.component.scss']
})
export class CrearpersonaComponent implements OnInit {
  persona:Persona=new Persona();
  constructor(private router:Router,private personaService:ServicepersonaService) { }

  ngOnInit(): void {
  }
  guardar():void{
    console.log(this.persona)
    this.personaService.guardarPersonas(this.persona).subscribe(data=>{
      console.log(data);
    });
    let params: NavigationExtras= {
      queryParams: {
        persona:this.persona

      }
    }
    this.router.navigate(['listarpersona'],params);
  }

}
