import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class MatSnackbarService {

  constructor(private matSnackBar: MatSnackBar) { }

  openSnackBar(message: string, action: string) {
    this.matSnackBar.open(message, action, {
      duration: 3000
    });
  }
}
