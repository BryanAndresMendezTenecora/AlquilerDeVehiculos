import { Component, OnInit } from '@angular/core';
import { PedidoService } from 'src/app/services/pedido.service';
import { VehiculoService } from '../../services/vehiculo.service';

@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.scss']
})
export class ListarVehiculoComponent implements OnInit {
vehiculos:any;
  constructor(private VehiculoService:VehiculoService ,private pedidoSERvice:PedidoService) { }

  ngOnInit(): void {
    this.vehiculos=this.VehiculoService.getVehiculo();
  }

  adicionarCarrito(vehiculo: any){
    window.alert("vehiculo adicionado al carrito con el nombre "+ vehiculo.marca);
    this.pedidoSERvice.adicionarCarrito(vehiculo);
  }

}
