import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CarFormComponent } from "./car-form/car-form.component";
import { CarListComponent } from "./car-list/car-list.component";


const routes: Routes = [
{ path: 'car-form', component: CarFormComponent },
{ path: 'car-list', component: CarListComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})

export class CarRoutingModule { }