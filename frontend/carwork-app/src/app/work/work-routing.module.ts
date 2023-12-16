import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { WorkFormComponent } from "./work-form/work-form.component";
import { WorkListComponent } from "./work-list/work-list.component";

const routes: Routes = [
{ path: 'work-form', component: WorkFormComponent },
{ path: 'work-list', component: WorkListComponent }
];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class WorkRoutingModule {}

