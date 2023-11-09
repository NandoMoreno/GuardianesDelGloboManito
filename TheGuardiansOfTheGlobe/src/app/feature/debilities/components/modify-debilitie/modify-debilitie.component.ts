import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modify-debilitie',
  templateUrl: './modify-debilitie.component.html',
  styleUrls: ['./modify-debilitie.component.css']
})
export class ModifyDebilitieComponent {

  constructor(
    public dialogRef: MatDialogRef<ModifyDebilitieComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
