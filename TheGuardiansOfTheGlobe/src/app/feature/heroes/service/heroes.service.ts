import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { environment } from 'src/environments/environment';
import { Heroes } from '../model/heroes';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeroesService {

  private url: string = environment.UrlBase+"/api/hero/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
    ) { }

    consultarListaHeroes(): Observable<Heroes[]>{
      return this.httpClient.get<Heroes[]>(`${this.url}consultarhero`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    consultarListaHeroesPorNombre(nombre: string): Observable<Heroes[]>{
      return this.httpClient.get<Heroes[]>(`${this.url}consultarheropornombre?name=${nombre}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }

    consultarListaHeroesPorHabilidad(id: number): Observable<Heroes[]>{
      return this.httpClient.get<Heroes[]>(`${this.url}consultarheroporhabilidad?hability=${id}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }

    guardarHeroe(heroe: Heroes): Observable<Heroes>{
      return this.httpClient.post<Heroes>(`${this.url}guardarhero`, heroe).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    modificarHeroe(heroe: Heroes): Observable<Heroes>{
      return this.httpClient.post<Heroes>(`${this.url}actualizarhero`, heroe).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    eliminarHeroe(idHeroe: number): Observable<Heroes>{
      return this.httpClient.delete<Heroes>(`${this.url}eliminarhero?id=${idHeroe}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }

}
