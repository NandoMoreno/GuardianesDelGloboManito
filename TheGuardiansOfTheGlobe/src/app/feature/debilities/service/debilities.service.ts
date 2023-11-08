import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { Debilities } from '../model/debilities';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DebilitiesService {

  private url: string = environment.UrlBase+"/api/debilities/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
    ) { }

    consultarListaDebilities(): Observable<Debilities[]>{
      return this.httpClient.get<Debilities[]>(`${this.url}consultardebilities`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    consultarListaDebilitiesPorNombre(nombre: string): Observable<Debilities[]>{
      return this.httpClient.get<Debilities[]>(`${this.url}consultardebilitiespornombre?name=${nombre}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    guardarDebilitie(debilitie: Debilities): Observable<Debilities>{
      return this.httpClient.post<Debilities>(`${this.url}guardardebilitie`, debilitie).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    modificarDebilitie(debilitie: Debilities): Observable<Debilities>{
      return this.httpClient.post<Debilities>(`${this.url}actualizardebilitie`, debilitie).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    eliminarDebilitie(idDebilitie: number): Observable<Debilities>{
      return this.httpClient.delete<Debilities>(`${this.url}eliminardebilitie?id=${idDebilitie}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
}
