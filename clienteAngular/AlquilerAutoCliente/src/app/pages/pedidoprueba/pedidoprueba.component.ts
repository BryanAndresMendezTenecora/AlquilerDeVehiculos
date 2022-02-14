import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pedido } from 'src/app/domain/pedido';

@Component({
  selector: 'app-pedidoprueba',
  templateUrl: './pedidoprueba.component.html',
  styleUrls: ['./pedidoprueba.component.scss']
})
export class PedidopruebaComponent implements OnInit {
  cedula:any;
  pedido:Pedido=new Pedido();
  constructor(private activatedRoute:ActivatedRoute) { 
    this.cedula=this.activatedRoute.snapshot.params['cedula'];
    console.log("llega===>",this.cedula)
    this.pedido.persona.cedula=this.cedula
    console.log("pasa valor a id===>",this.pedido.id)
  }

  ngOnInit(): void {
  }

}
