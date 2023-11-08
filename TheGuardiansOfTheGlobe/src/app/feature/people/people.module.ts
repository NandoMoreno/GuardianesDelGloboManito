import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PeopleRoutingModule } from './people-routing.module';
import { PeopleListComponent } from './components/people-list/people-list.component';

import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatStepperModule } from '@angular/material/stepper';
import { MatTableModule } from '@angular/material/table';
import { MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { PeopleService } from './service/people.service';
import { CoreModule } from 'src/app/core/core.module';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { CreatePeopleComponent } from './components/create-people/create-people.component';
import { ModifyPeopleComponent } from './components/modify-people/modify-people.component';
import { AnyKindComponent } from './components/any-kind/any-kind.component';

@NgModule({
  declarations: [
    PeopleListComponent,
    CreatePeopleComponent,
    ModifyPeopleComponent,
    AnyKindComponent
  ],
  imports: [
    CommonModule,
    PeopleRoutingModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatCardModule,
    MatDialogModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatMenuModule,
    MatRadioModule,
    MatSelectModule,
    MatSidenavModule,
    MatStepperModule,
    MatTableModule,
    MatSnackBarModule
  ], exports: [
    PeopleListComponent
  ], providers: [PeopleService]
})
export class PeopleModule { }
