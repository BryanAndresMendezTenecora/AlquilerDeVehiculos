import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrearpersonaComponent } from './pages/crearpersona/crearpersona.component';

import { ListarpersonaComponent } from './pages/listarpersona/listarpersona.component';
import { CrearVehiculoComponent } from './pages/crear-vehiculo/crear-vehiculo.component';
import { ListarVehiculoComponent } from './pages/listar-vehiculo/listar-vehiculo.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    CrearpersonaComponent,
    ListarpersonaComponent,
    CrearVehiculoComponent,
    ListarVehiculoComponent,
    

   

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
