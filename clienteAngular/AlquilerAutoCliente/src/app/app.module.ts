import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrearpersonaComponent } from './pages/crearpersona/crearpersona.component';

import { ListarpersonaComponent } from './pages/listarpersona/listarpersona.component';


@NgModule({
  declarations: [
    AppComponent,
<<<<<<< Updated upstream
    CrearpersonaComponent,
    ListarpersonaComponent
=======
   
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
