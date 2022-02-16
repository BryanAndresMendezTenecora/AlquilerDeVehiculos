import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-consultapedido',
  templateUrl: './consultapedido.component.html',
  styleUrls: ['./consultapedido.component.scss']
})
export class ConsultapedidoComponent implements OnInit {
  nombre:string;
  pedidos:any;
  constructor(private pedidoservice:PedidoService ,private router:Router) { }

  ngOnInit(): void {
    this.checkLocalStorage();
  }

  buscar(nombre:string){
    console.log("ingreseos-->>>",nombre)
    this.pedidos=this.pedidoservice.buscarpedido(nombre);
    console.log("estos son los vehiculos-->",this.pedidos)

  }
  checkLocalStorage(){
    if(localStorage.getItem('token')){
      this.router.navigate(['consultapedido'])
    }else{
      this.router.navigate(['login'])
    }

  }

}
