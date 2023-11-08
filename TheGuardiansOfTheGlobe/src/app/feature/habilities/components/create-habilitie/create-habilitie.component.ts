import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-habilitie',
  templateUrl: './create-habilitie.component.html',
  styleUrls: ['./create-habilitie.component.css']
})
export class CreateHabilitieComponent {

  constructor(
    public dialogRef: MatDialogRef<CreateHabilitieComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
