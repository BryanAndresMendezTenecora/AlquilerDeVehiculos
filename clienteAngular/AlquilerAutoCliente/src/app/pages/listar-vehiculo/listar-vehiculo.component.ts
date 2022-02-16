
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComentarioService } from 'src/app/services/comentario.service';

import { PedidoService } from 'src/app/services/pedido.service';
import { VehiculoService } from '../../services/vehiculo.service';

@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.scss']
})


export class ListarVehiculoComponent implements OnInit {
vehiculos:any;
comentarios:any;

  constructor(private VehiculoService:VehiculoService ,private pedidoSERvice:PedidoService,private router:Router, private ComentarioService:ComentarioService) { }


  ngOnInit(): void {
    this.comentarios=this.ComentarioService.getComentario();
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
