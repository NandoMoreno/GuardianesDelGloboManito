import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';

import {MatIconModule} from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { CoreRoutingModule } from './core-routing.module';
import { PeopleModule } from '../feature/people/people.module';

@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    HeaderComponent
  ],
  imports: [
    CoreRoutingModule,
    CommonModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    RouterModule,
    PeopleModule
  ], exports: [
    NavbarComponent, FooterComponent, HeaderComponent
  ]
})
export class CoreModule { }
