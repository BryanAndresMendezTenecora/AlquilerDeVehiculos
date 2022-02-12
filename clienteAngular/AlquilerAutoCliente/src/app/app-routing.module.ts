import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearpersonaComponent } from './pages/crearpersona/crearpersona.component';
import { ListarpersonaComponent } from './pages/listarpersona/listarpersona.component';
import { CrearVehiculoComponent } from './pages/crear-vehiculo/crear-vehiculo.component';
import { ListarVehiculoComponent } from './pages/listar-vehiculo/listar-vehiculo.component';

const routes: Routes = [
  {path:"crearpersona",component:CrearpersonaComponent},
  {path:"listarpersona",component:ListarpersonaComponent},
  {path:"crearVehiculo",component:CrearVehiculoComponent},
  {path:"listarVehiculo",component:ListarVehiculoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
