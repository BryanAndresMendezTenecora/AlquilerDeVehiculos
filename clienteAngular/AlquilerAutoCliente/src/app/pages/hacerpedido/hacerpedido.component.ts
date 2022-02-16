import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Detalle } from 'src/app/domain/detalle';
import { Pedido } from 'src/app/domain/pedido';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-hacerpedido',
  templateUrl: './hacerpedido.component.html',
  styleUrls: ['./hacerpedido.component.scss']
})
export class HacerpedidoComponent implements OnInit {
  items=[]as any;
  detalle:Detalle[];
  
  itemsd=[]as any;

  filas=['1','2','3','4'];
  constructor(private pedidoService:PedidoService,private pedidoSERvice:PedidoService,private router:Router) { }


  //credo para guardar persona
  
  pedido:Pedido=new Pedido();
  detalles:Detalle=new Detalle();

  detaller:Detalle=new Detalle();
  
  ngOnInit(): void {
    this.items=this.pedidoService.ListarCarrito();
    console.log(this.items)
    this.detalle=this.pedidoSERvice.ListarDetalle();
    //this.pedido.detalles=this.detalle;
   
    console.log('here-->',this.itemsd)
    this.checkLocalStorage();
  }

  guardar():void{
    console.log(this.pedido)
   
    this.pedido.detalles=this.detalle;
    console.log('listar pedido detalle--',this.pedido.detalles)
    this.pedidoService.guardarPedidos(this.pedido).subscribe(data=>{
      console.log(data);
    });
  }

  //para guardar dettales
  adicionarDetalle(){
    //window.alert("persona adicionada ala carrito con el id "+ this.detalles.id);
    //window.alert("persona adicionada ala carrito con el id "+ detalle.id);

    
    this.pedidoSERvice.adicionarDetalle(this.detalles=new Detalle())
    //this.pedidoSERvice.adicionarDetalle(det)
      console.log("--->",this.detalles);

  }

  checkLocalStorage(){
    if(localStorage.getItem('token')){
      this.router.navigate(['listarPedido'])
    }else{
      this.router.navigate(['login'])
    }

  }
   

}
