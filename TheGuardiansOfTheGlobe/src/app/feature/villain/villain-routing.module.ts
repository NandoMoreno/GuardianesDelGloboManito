import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VillainListComponent } from './components/villain-list/villain-list.component';

const routes: Routes = [
  { path: "", component: VillainListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VillainRoutingModule { }
