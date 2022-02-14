import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearpersonaComponent } from './pages/crearpersona/crearpersona.component';
import { ListarpersonaComponent } from './pages/listarpersona/listarpersona.component';
import { CrearVehiculoComponent } from './pages/crear-vehiculo/crear-vehiculo.component';
import { ListarVehiculoComponent } from './pages/listar-vehiculo/listar-vehiculo.component';
import { PedidopruebaComponent } from './pages/pedidoprueba/pedidoprueba.component';
import { HacerpedidoComponent } from './pages/hacerpedido/hacerpedido.component';

const routes: Routes = [
  {path:"crearpersona",component:CrearpersonaComponent},
  {path:"listarpersona",component:ListarpersonaComponent},
  {path:"crearVehiculo",component:CrearVehiculoComponent},
  {path:"listarVehiculo",component:ListarVehiculoComponent},
  {path:"pedido",component:PedidopruebaComponent},
  {path:"pedido/:cedula",component:PedidopruebaComponent},
  //{path:'',component:HacerpedidoComponent}
  {path:"listarPedido",component:HacerpedidoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
