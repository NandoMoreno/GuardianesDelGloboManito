import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DebilitiesService } from '../../service/debilities.service';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { MatPaginator } from '@angular/material/paginator';
import { ReplaySubject } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { Debilities } from '../../model/debilities';

@Component({
  selector: 'app-debilities-list',
  templateUrl: './debilities-list.component.html',
  styleUrls: ['./debilities-list.component.css']
})
export class DebilitiesListComponent {

  
  public debilidadEscogida: Debilities;
  public debilidades: Debilities[] = [];

  public rolFilter: ReplaySubject<Debilities[]> = new ReplaySubject<Debilities[]>(1);
  public form: FormGroup;
  dataSource = new MatTableDataSource<Debilities>(this.debilidades);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  public displayedColumns: string[] = [
    'Id',
    'Nombre',
  ];

  constructor(
    private formsBuilder: FormBuilder,
    private debilitiesService: DebilitiesService,
    private dialog: MatDialog,
    private matSnackbarService: MatSnackbarService,
  ) {}

  ngOnInit(): void {
    this.form = this.formsBuilder.group({
      nombre: '',
      habilidad: '',
    });
    this.consultarDebilidades();
  }

  resetForm() {
    this.form.reset();
    this.consultarDebilidades();
  }

  buscarPorNombre() {
    this.consultarHeroesPorNombre(this.form.controls['nombre'].value);
  }

  consultarDebilidades(): void {
    this.debilitiesService.consultarListaDebilities().subscribe(req => {
      if (req) {
        this.debilidades = req;
      }
    })
  }

  consultarHeroesPorNombre(nombre: string): void {
    this.debilitiesService.consultarListaDebilitiesPorNombre(nombre).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Debilities>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

}
