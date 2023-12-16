import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientFormComponent } from './client-form/client-form.component';
import { ClientListComponent } from './client-list/client-list.component';


const routes: Routes = [
{ path: 'client-form', component: ClientFormComponent },
{ path: 'client-form/:id', component: ClientFormComponent },
{ path: 'client-list', component: ClientListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientRoutingModule { }
