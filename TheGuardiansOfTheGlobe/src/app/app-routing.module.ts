import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./core/core.module').then(m => m.CoreModule) 
  },{
    path: 'People',
    loadChildren: () => import('./feature/people/people.module').then(m => m.PeopleModule) 
  },{
    path: 'Heroes',
    loadChildren: () => import('./feature/heroes/heroes.module').then(m => m.HeroesModule) 
  },{
    path: 'Villains',
    loadChildren: () => import('./feature/villain/villain.module').then(m => m.VillainModule) 
  },{
    path: 'Habilities',
    loadChildren: () => import('./feature/habilities/habilities.module').then(m => m.HabilitiesModule) 
  },{
    path: 'Debilities',
    loadChildren: () => import('./feature/debilities/debilities.module').then(m => m.DebilitiesModule) 
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
