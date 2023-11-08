import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HabilitiesListComponent } from './components/habilities-list/habilities-list.component';

const routes: Routes = [
  { path:"", component: HabilitiesListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HabilitiesRoutingModule { }
