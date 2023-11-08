import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HabilitiesRoutingModule } from './habilities-routing.module';
import { HabilitiesListComponent } from './components/habilities-list/habilities-list.component';
import { CreateHabilitieComponent } from './components/create-habilitie/create-habilitie.component';
import { ModifiyHabilitieComponent } from './components/modifiy-habilitie/modifiy-habilitie.component';

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
import { CoreModule } from 'src/app/core/core.module';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';

@NgModule({
  declarations: [
    HabilitiesListComponent,
    CreateHabilitieComponent,
    ModifiyHabilitieComponent
  ],
  imports: [
    CommonModule,
    HabilitiesRoutingModule,
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
    HabilitiesListComponent
  ]
})
export class HabilitiesModule { }
