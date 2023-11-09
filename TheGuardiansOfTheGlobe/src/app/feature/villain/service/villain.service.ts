import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { environment } from 'src/environments/environment';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VillainService {

  private url: string = environment.UrlBase+"/api/villain/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
    ) { }
}
