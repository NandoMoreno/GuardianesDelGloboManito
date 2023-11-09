import { Component, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { DebilitiesService } from '../../service/debilities.service';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { MatPaginator } from '@angular/material/paginator';
import { ReplaySubject } from 'rxjs';
import { MatTableDataSource } from '@angular/material/table';
import { Debilities } from '../../model/debilities';
import { CreateDebilitieComponent } from '../create-debilitie/create-debilitie.component';
import { ModifyDebilitieComponent } from '../modify-debilitie/modify-debilitie.component';

@Component({
  selector: 'app-debilities-list',
  templateUrl: './debilities-list.component.html',
  styleUrls: ['./debilities-list.component.css']
})
export class DebilitiesListComponent {

  public debilidadAux: Debilities = {
    name: ''
  };
  public debilidadEscogida: Debilities;
  public debilidades: Debilities[] = [];

  public rolFilter: ReplaySubject<Debilities[]> = new ReplaySubject<Debilities[]>(1);
  public form: FormGroup;
  dataSource = new MatTableDataSource<Debilities>(this.debilidades);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  public displayedColumns: string[] = [
    'Id',
    'Nombre',
    'Opciones',
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
    });
    this.consultarDebilidades();
  }

  resetForm() {
    this.form.reset();
    this.consultarDebilidades();
  }

  buscarPorNombre() {
    this.consultarDebilidadPorNombre(this.form.controls['nombre'].value);
  }

  consultarDebilidades(): void {
    this.debilitiesService.consultarListaDebilities().subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Debilities>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarDebilidadPorNombre(nombre: string): void {
    this.debilitiesService.consultarListaDebilitiesPorNombre(nombre).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Debilities>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  guardarDebilidad(): void{
    let debilidad: Debilities = {
      name: this.debilidadAux.name
    }
    this.debilitiesService.guardarDebilitie(debilidad).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Debilidad ${this.debilidadAux.name} creada con exito`, "Cerrar");
        this.consultarDebilidades();
      }
    })
  }

  modificarDebilidad(debilidad: Debilities): void{
    this.debilitiesService.modificarDebilitie(debilidad).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Debilidad ${this.debilidadAux.name} modificada con exito`, "Cerrar");
        this.consultarDebilidades();
      }
    })
  }

  eliminarDebilidad(debilidad: Debilities): void{
    this.debilitiesService.eliminarDebilitie(Number (debilidad.id)).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Debilidad ${debilidad.name} eliminada con exito`, "cerrar");
        this.consultarDebilidades();
      }
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreateDebilitieComponent, {
      data: { 
        name: this.debilidadAux.name
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.debilidadAux.name = result.name;
      this.guardarDebilidad();
      this.debilidadAux.name = '';
    });
  }

  openModifyDialog(debilidadParam: Debilities): void {
    const dialogRef = this.dialog.open(ModifyDebilitieComponent, {
      data: { 
        id: debilidadParam.id,
        name: debilidadParam.name, 
      },
      
    });

    dialogRef.afterClosed().subscribe(result => {
      this.debilidadAux.id = result.id;
      this.debilidadAux.name = result.name;
      this.modificarDebilidad(this.debilidadAux);
    });
  }

}
