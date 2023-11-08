import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-modify-people',
  templateUrl: './modify-people.component.html',
  styleUrls: ['./modify-people.component.css']
})
export class ModifyPeopleComponent implements OnInit{

  constructor(
    public dialogRef: MatDialogRef<ModifyPeopleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {}

  ngOnInit(): void {
    
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
