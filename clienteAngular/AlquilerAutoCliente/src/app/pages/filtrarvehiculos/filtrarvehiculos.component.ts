import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculoService } from 'src/app/services/vehiculo.service';

@Component({
  selector: 'app-filtrarvehiculos',
  templateUrl: './filtrarvehiculos.component.html',
  styleUrls: ['./filtrarvehiculos.component.scss']
})
export class FiltrarvehiculosComponent implements OnInit {
  nombre:string;
  vehiculos:any;
  constructor(private vehiculoservice:VehiculoService,private router:Router) { }

  ngOnInit(): void {
    this.checkLocalStorage();
  }

  buscar(nombre:string){
    console.log("ingreseos-->>>",nombre)
    this.vehiculos=this.vehiculoservice.buscarvehiculo(nombre);
    console.log("estos son los vehiculos-->",this.vehiculos)

  }
  checkLocalStorage(){
    if(localStorage.getItem('token')){
      this.router.navigate(['listarporcategoria'])
    }else{
      this.router.navigate(['login'])
    }

  }

}
