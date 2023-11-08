import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VillainRoutingModule } from './villain-routing.module';
import { VillainListComponent } from './components/villain-list/villain-list.component';


@NgModule({
  declarations: [
    VillainListComponent
  ],
  imports: [
    CommonModule,
    VillainRoutingModule
  ]
})
export class VillainModule { }
