import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HeroesService } from '../../service/heroes.service';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Heroes } from '../../model/heroes';
import { ReplaySubject } from 'rxjs';
import { HabilitiesService } from 'src/app/feature/habilities/service/habilities.service';
import { Habilities } from 'src/app/feature/habilities/model/habilities';

@Component({
  selector: 'app-heroes-list',
  templateUrl: './heroes-list.component.html',
  styleUrls: ['./heroes-list.component.css']
})
export class HeroesListComponent {

  public habilidadEscogida: Habilities;
  public habilidades: Habilities[] = [];

  public heroes: Heroes[] = [];
  public rolFilter: ReplaySubject<Heroes[]> = new ReplaySubject<Heroes[]>(1);
  public form: FormGroup;
  dataSource = new MatTableDataSource<Heroes>(this.heroes);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  public displayedColumns: string[] = [
    'Id',
    'Wins',
    'Nombre',
    'Edad',
    'Rango',
    'Habilidad'
  ];

  constructor(
    private formsBuilder: FormBuilder,
    private heroService: HeroesService,
    private dialog: MatDialog,
    private matSnackbarService: MatSnackbarService,
    private habilitiesService: HabilitiesService
  ) {}

  ngOnInit(): void {
    this.form = this.formsBuilder.group({
      nombre: '',
      habilidad: '',
    });
    this.consultarHeroes();
    this.consultarHabilidades();
  }

  resetForm() {
    this.form.reset();
    this.consultarHeroes();
  }

  buscarPorNombre() {
    this.consultarHeroesPorNombre(this.form.controls['nombre'].value);
  }

  buscarPorHabilidad() {
    this.consultarHeroesPorHabilidad();
  }

  consultarHabilidades(): void {
    this.habilitiesService.consultarListaHabilidades().subscribe(req => {
      if (req) {
        this.habilidades = req;
      }
    })
  }

  consultarHeroes(): void {
    this.heroService.consultarListaHeroes().subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Heroes>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarHeroesPorNombre(nombre: string): void {
    this.heroService.consultarListaHeroesPorNombre(nombre).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Heroes>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  onChange(centroId: any) {
    console.log(centroId); // Aquí iría tu lógica al momento de seleccionar algo
}

  consultarHeroesPorHabilidad(): void {
    console.log(this.habilidadEscogida.id);
    
    this.heroService.consultarListaHeroesPorHabilidad(Number(this.habilidadEscogida.id)).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Heroes>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

}
