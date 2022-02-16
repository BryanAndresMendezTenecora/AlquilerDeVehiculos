import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { Pedido } from 'src/app/domain/pedido';
import { Persona } from 'src/app/domain/persona';
import { PedidoService } from 'src/app/services/pedido.service';
import { ServicepersonaService } from 'src/app/services/servicepersona.service';

@Component({
  selector: 'app-listarpersona',
  templateUrl: './listarpersona.component.html',
  styleUrls: ['./listarpersona.component.scss']
})
export class ListarpersonaComponent implements OnInit {
  personas:any;
  //persona:Persona;
  ///pedido:Pedido;
 
  constructor(private personasService:ServicepersonaService ,private pedidoSERvice:PedidoService ) { }

  ngOnInit(): void {
    this.personas=this.personasService.getPersonas();
  }

  editar(pedido:Pedido){

  }
  adicionarCarrito(persona:any){
    window.alert("persona adicionada ala carrito con el id "+ persona.nombre);
    this.pedidoSERvice.adicionarCarrito(persona)
    


  }

  

}