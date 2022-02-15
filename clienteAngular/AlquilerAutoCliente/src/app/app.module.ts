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
import { PedidopruebaComponent } from './pages/pedidoprueba/pedidoprueba.component';
import { HacerpedidoComponent } from './pages/hacerpedido/hacerpedido.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FiltrarvehiculosComponent } from './pages/filtrarvehiculos/filtrarvehiculos.component';
import { LoginComponent } from './pages/login/login.component';
import { HeaderComponent } from './plantillas/header/header.component';
import { FooterComponent } from './plantillas/footer/footer.component';


@NgModule({
  declarations: [
    AppComponent,
    CrearpersonaComponent,
    ListarpersonaComponent,
    CrearVehiculoComponent,
    ListarVehiculoComponent,
    PedidopruebaComponent,
    HacerpedidoComponent,
    FiltrarvehiculosComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    

   

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
