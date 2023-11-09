import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SponsorRoutingModule } from './sponsor-routing.module';
import { SponsorsListComponent } from './components/sponsors-list/sponsors-list.component';
import { CreateSponsorComponent } from './components/create-sponsor/create-sponsor.component';
import { ModifySponsorComponent } from './components/modify-sponsor/modify-sponsor.component';

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
import { SponsorService } from './service/sponsor.service';

@NgModule({
  declarations: [
    SponsorsListComponent,
    CreateSponsorComponent,
    ModifySponsorComponent
  ],
  imports: [
    CommonModule,
    SponsorRoutingModule,
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
    SponsorService
  ]
})
export class SponsorModule { }
