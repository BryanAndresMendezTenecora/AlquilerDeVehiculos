import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../../services/vehiculo.service';

@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.scss']
})
export class ListarVehiculoComponent implements OnInit {
vehiculos:any;
  constructor(private VehiculoService:VehiculoService ) { }

  ngOnInit(): void {
    this.vehiculos=this.VehiculoService.getVehiculo();
  }

}
