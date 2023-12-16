import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CarFormComponent } from "./car-form/car-form.component";
import { CarListComponent } from "./car-list/car-list.component";
import { LayoutComponent } from "../layout/layout.component";
import { AuthGuard } from "../auth.guard";

const routes: Routes = [

{path: 'car', component: LayoutComponent,
canActivate: [AuthGuard], children: [
{path:'form', component: CarFormComponent},
{path: 'list', component: CarListComponent},
{path: '', redirectTo: '/car/list', pathMatch: 'full'}
]},

];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})

export class CarRoutingModule { }