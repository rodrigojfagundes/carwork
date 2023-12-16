import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { WorkRoutingModule } from "./work-routing.module";
import { WorkFormComponent } from "./work-form/work-form.component";
import { WorkListComponent } from "./work-list/work-list.component";
import { RouterModule } from "@angular/router";


@NgModule({
    declarations: [
        WorkFormComponent,
        WorkListComponent
    ],
    imports: [
        CommonModule,
        WorkRoutingModule,
        FormsModule,
        RouterModule
    ], exports: [
        WorkFormComponent,
        WorkListComponent
    ]
})

export class WorkModule { }

