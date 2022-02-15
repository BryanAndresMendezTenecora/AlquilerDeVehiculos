
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehiculoService } from '../../services/vehiculo.service';
import { PedidoService } from '../../services/pedido.service';




@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.scss']
})


export class ListarVehiculoComponent implements OnInit {
vehiculos:any;

  constructor(private VehiculoService:VehiculoService ,private pedidoSERvice:PedidoService,private router:Router) { }


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
