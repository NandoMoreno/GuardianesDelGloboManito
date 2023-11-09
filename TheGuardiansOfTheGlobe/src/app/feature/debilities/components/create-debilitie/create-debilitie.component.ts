import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-debilitie',
  templateUrl: './create-debilitie.component.html',
  styleUrls: ['./create-debilitie.component.css']
})
export class CreateDebilitieComponent {

  constructor(
    public dialogRef: MatDialogRef<CreateDebilitieComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
