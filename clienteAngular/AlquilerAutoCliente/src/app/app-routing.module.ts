import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearpersonaComponent } from './pages/crearpersona/crearpersona.component';
import { ListarpersonaComponent } from './pages/listarpersona/listarpersona.component';

const routes: Routes = [
  {path:"crearpersona",component:CrearpersonaComponent},
  {path:"listarpersona",component:ListarpersonaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
