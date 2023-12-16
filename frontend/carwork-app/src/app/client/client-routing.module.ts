import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientListComponent } from './client-list/client-list.component';
import { LayoutComponent } from "../layout/layout.component";
import { AuthGuard } from "../auth.guard";
import { CarFormComponent } from '../car/car-form/car-form.component';



const routes: Routes = [
{ path: 'client', canActivate: [AuthGuard], component: LayoutComponent, children:[
{ path: 'form', component: ClientFormComponent },
{ path: 'list', component: ClientListComponent },
{ path: '', redirectTo: '/client/list', pathMatch: 'full' }
] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
