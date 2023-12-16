import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { CarFormComponent } from "./car-form/car-form.component"; 
import { CarListComponent } from "./car-list/car-list.component";
import { CarRoutingModule } from "./car-routing.module";


@NgModule({
    declarations: [
        CarFormComponent,
        CarListComponent
    ], imports: [
        CommonModule,
        CarRoutingModule,
        FormsModule,
        RouterModule
    ], exports: [
        CarFormComponent,
        CarListComponent
    ]
})

export class CarModule { }