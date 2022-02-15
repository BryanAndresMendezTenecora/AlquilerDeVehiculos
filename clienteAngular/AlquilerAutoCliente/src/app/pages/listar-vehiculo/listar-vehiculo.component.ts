<<<<<<< HEAD
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
=======
import { Component, OnInit, Input } from '@angular/core';
>>>>>>> 0d28f0e9c5353b61c4acce6c15435c16c82687c0
import { PedidoService } from 'src/app/services/pedido.service';
import { VehiculoService } from '../../services/vehiculo.service';

@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.scss']
})


export class ListarVehiculoComponent implements OnInit {
vehiculos:any;
<<<<<<< HEAD
  constructor(private VehiculoService:VehiculoService ,private pedidoSERvice:PedidoService,private router:Router) { }
=======

@Input()
nombre:'DesarrolloWeb';


  constructor(private VehiculoService:VehiculoService ,private pedidoSERvice:PedidoService) { }
>>>>>>> 0d28f0e9c5353b61c4acce6c15435c16c82687c0

  ngOnInit(): void {
    this.vehiculos=this.VehiculoService.getVehiculo();
    this.checkLocalStorage()
  }

  adicionarCarrito(vehiculo: any){
    window.alert("vehiculo adicionado al carrito con el nombre "+ vehiculo.marca);
    this.pedidoSERvice.adicionarCarrito(vehiculo);
  }
  salir(){
    console.log("token------>")
    localStorage.clear()
    this.router.navigate(['login'])
  }


  checkLocalStorage(){
    if(localStorage.getItem('token')){
      this.router.navigate(['listarVehiculo'])
    }else{
      this.router.navigate(['login'])
    }

  }
  

}
