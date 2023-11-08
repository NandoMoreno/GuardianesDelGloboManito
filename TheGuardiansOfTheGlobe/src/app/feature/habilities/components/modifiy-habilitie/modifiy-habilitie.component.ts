import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modifiy-habilitie',
  templateUrl: './modifiy-habilitie.component.html',
  styleUrls: ['./modifiy-habilitie.component.css']
})
export class ModifiyHabilitieComponent {

  constructor(
    public dialogRef: MatDialogRef<ModifiyHabilitieComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  ngOnInit(): void {
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
