import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { WorkFormComponent } from "./work-form/work-form.component";
import { WorkListComponent } from "./work-list/work-list.component";
import { LayoutComponent } from "../layout/layout.component";
import { AuthGuard } from "../auth.guard";

const routes: Routes = [
{ path: 'work', canActivate: [AuthGuard], component: LayoutComponent, children: [
{ path: 'form', component: WorkFormComponent },
{ path: 'list', component: WorkListComponent },
{ path: '', redirectTo: '/work/list', pathMatch: 'full' }

] }

];

@NgModule({
imports: [RouterModule.forChild(routes)],
exports: [RouterModule]
})
export class WorkRoutingModule {}

