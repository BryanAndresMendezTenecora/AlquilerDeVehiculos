import { Component, OnInit } from '@angular/core';
import { Vehiculo } from '../../domain/Vehiculo';
import { VehiculoService } from '../../services/vehiculo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear-vehiculo',
  templateUrl: './crear-vehiculo.component.html',
  styleUrls: ['./crear-vehiculo.component.scss']
})
export class CrearVehiculoComponent implements OnInit {

  vehiculo:Vehiculo=new Vehiculo();
  constructor(private router:Router,private VehiculoService:VehiculoService) { }

  ngOnInit(): void {
   
  }

  guardar(){
    console.log(this.vehiculo)
    this.VehiculoService.guardarVehiculo(this.vehiculo).subscribe(data=>{
      console.log(data);
    });
    
  }
  

}
