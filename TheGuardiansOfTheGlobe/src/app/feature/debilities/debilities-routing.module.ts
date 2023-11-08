import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DebilitiesListComponent } from './components/debilities-list/debilities-list.component';

const routes: Routes = [
  {path: '', component: DebilitiesListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DebilitiesRoutingModule { }
