import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { environment } from 'src/environments/environment';
import { Observable, catchError, throwError } from 'rxjs';
import Sponsor from '../model/sponsor';

@Injectable({
  providedIn: 'root'
})
export class SponsorService {

  private url: string = environment.UrlBase+"/api/sponsor/";

  constructor(
    public httpClient: HttpClient,
    public matSnackbarService: MatSnackbarService
    ) { }

    consultarListaSponsor(): Observable<Sponsor[]>{
      return this.httpClient.get<Sponsor[]>(`${this.url}consultarsponsor`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    consultarListaSponsorPorNombre(nombre: string): Observable<Sponsor[]>{
      return this.httpClient.get<Sponsor[]>(`${this.url}consultarheropornombre?name=${nombre}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }

    consultarListaSponsorPorDebilidad(id: number): Observable<Sponsor[]>{
      return this.httpClient.get<Sponsor[]>(`${this.url}consultarheroporhabilidad?hability=${id}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }

    guardarHeroe(heroe: Sponsor): Observable<Sponsor>{
      return this.httpClient.post<Sponsor>(`${this.url}guardarhero`, heroe).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    modificarHeroe(heroe: Sponsor): Observable<Sponsor>{
      return this.httpClient.post<Sponsor>(`${this.url}actualizarhero`, heroe).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
  
    eliminarHeroe(idHeroe: number): Observable<Sponsor>{
      return this.httpClient.delete<Sponsor>(`${this.url}eliminarhero?id=${idHeroe}`).pipe(
        catchError(e => {
          this.matSnackbarService.openSnackBar(e.error, "Cerrar");
          return throwError(e);
        }) 
      );
    }
}
