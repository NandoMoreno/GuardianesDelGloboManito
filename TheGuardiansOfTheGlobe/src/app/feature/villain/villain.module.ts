import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VillainRoutingModule } from './villain-routing.module';
import { VillainListComponent } from './components/villain-list/villain-list.component';
import { ModifyVillainComponent } from './components/modify-villain/modify-villain.component';
import { CreateVillainComponent } from './components/create-villain/create-villain.component';

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
import { MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { CoreModule } from 'src/app/core/core.module';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { MatTableModule } from '@angular/material/table';
import { VillainService } from './service/villain.service';

@NgModule({
  declarations: [
    VillainListComponent,
    ModifyVillainComponent,
    CreateVillainComponent
  ],
  imports: [
    CommonModule,
    VillainRoutingModule,
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
  ], providers: [
    VillainService
  ]
})
export class VillainModule { }
