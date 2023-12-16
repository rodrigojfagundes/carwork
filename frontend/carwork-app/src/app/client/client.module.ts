import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientRoutingModule } from './client-routing.module';
import { ClientFormComponent } from './client-form/client-form.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [ClientFormComponent],
  imports: [
    CommonModule,
    ClientRoutingModule,
    FormsModule
  ], exports: [
  ClientFormComponent
  ]
})
export class ClientModule { }
