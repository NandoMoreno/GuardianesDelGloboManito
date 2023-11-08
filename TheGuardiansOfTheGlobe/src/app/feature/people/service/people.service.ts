import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { People } from '../model/people';
import { environment } from 'src/environments/environment';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';

@Injectable()
export class PeopleService {

  private url: string = environment.UrlBase+"/api/people/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
    ) { }

  consultarListaPersonas(): Observable<People[]>{
    return this.httpClient.get<People[]>(`${this.url}consultarpersonas`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  consultarListaPersonasPorNombre(nombre: string): Observable<People[]>{
    return this.httpClient.get<People[]>(`${this.url}consultarpersonaspornombre?nombre=${nombre}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  consultarListaPersonasPorEdad(edad: number): Observable<People[]>{
    return this.httpClient.get<People[]>(`${this.url}consultarpersonasporedad?edad=${edad}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  consultarListaPersonasPorRango(rango: string): Observable<People[]>{
    return this.httpClient.get<People[]>(`${this.url}consultarpersonasporrango?rango=${rango}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  guardarPersona(persona: People): Observable<People>{
    return this.httpClient.post<People>(`${this.url}guardarpersona`, persona).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  modificarPersona(persona: People): Observable<People>{
    return this.httpClient.post<People>(`${this.url}actualizarpersona`, persona).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  eliminarPersona(idPersona: number): Observable<People>{
    return this.httpClient.delete<People>(`${this.url}eliminarpersona?id=${idPersona}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }
}
