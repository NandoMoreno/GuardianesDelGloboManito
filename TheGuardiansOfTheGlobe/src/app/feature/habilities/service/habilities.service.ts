import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { environment } from 'src/environments/environment';
import { Habilities } from '../model/habilities';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HabilitiesService {

  private url: string = environment.UrlBase+"/api/habilities/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
  ) { }

  consultarListaHabilidades(): Observable<Habilities[]>{
    return this.httpClient.get<Habilities[]>(`${this.url}consultarhabilidades`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  consultarListaHabilidadesPorNombre(nombre: string): Observable<Habilities[]>{
    return this.httpClient.get<Habilities[]>(`${this.url}consultarhabilidadpornombre?nombre=${nombre}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  guardarHabilidad(habilidad: Habilities): Observable<Habilities>{
    return this.httpClient.post<Habilities>(`${this.url}guardarhabilidad`, habilidad).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  modificarHabilidad(habilidad: Habilities): Observable<Habilities>{
    return this.httpClient.post<Habilities>(`${this.url}actualizarhabilidad`, habilidad).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }

  eliminarHabilidad(id: number): Observable<Habilities>{
    return this.httpClient.delete<Habilities>(`${this.url}eliminarhabilidad?id=${id}`).pipe(
      catchError(e => {
        this.matSnackbarService.openSnackBar(e.error, "Cerrar");
        return throwError(e);
      }) 
    );
  }
}
