import { HttpClient } from '@angular/common/http';
import { identifierName } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pedido } from '../domain/pedido';
import { Persona } from '../domain/persona';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  personas:Persona;
  items=[] as any;
  detalles=[] as any;
  constructor(private http:HttpClient) { }

  adicionarCarrito(vehiculo:any){
    this.items.push(vehiculo)
  }
  LimpiarCarrito(){
    this.items=[];
    return this.items;

  }
  ListarCarrito(){
    return this.items
  }
  //para guardar pedidos
  guardarPedidos(pedido : Pedido):Observable<any>{
    const url = "http://localhost:8080/AlquilerAutoServer/ws/pedido";
    return this.http.put<any>(url,pedido)
  }

  limpiarDetalle(){
    this.detalles=[];
  }
  //guardamos detalles e
  adicionarDetalle(detalle:any){
    let encontrado=false;
    this.detalles.forEach((elemento:any) =>{
      console.log(detalle.id);
      if(elemento.id == detalle.id){
        console.log("encontrado"+elemento.id);
        encontrado=true;
        elemento.cantidad+=1;
      }
    });
    if(!encontrado)
    this.detalles.push(detalle)
    
  }
  //listar detalle
  ListarDetalle(){
    return this.detalles
  }

  buscarpedido(nombre:string):Observable<any>{
    console.log("service->",nombre)
    const url = "http://localhost:8080/AlquilerAutoServer/ws/pedido/buscarP";
    return this.http.post<any>(url,nombre)

  }
}
