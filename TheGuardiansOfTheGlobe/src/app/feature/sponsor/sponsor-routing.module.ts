import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SponsorsListComponent } from './components/sponsors-list/sponsors-list.component';

const routes: Routes = [
  { path: "", component: SponsorsListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SponsorRoutingModule { }
