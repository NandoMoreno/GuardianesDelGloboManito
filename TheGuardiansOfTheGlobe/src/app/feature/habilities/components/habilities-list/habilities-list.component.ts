import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { ReplaySubject, Subject } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { Habilities } from '../../model/habilities';
import { HabilitiesService } from '../../service/habilities.service';
import { CreateHabilitieComponent } from '../create-habilitie/create-habilitie.component';
import { ModifiyHabilitieComponent } from '../modifiy-habilitie/modifiy-habilitie.component';

@Component({
  selector: 'app-habilities-list',
  templateUrl: './habilities-list.component.html',
  styleUrls: ['./habilities-list.component.css']
})
export class HabilitiesListComponent {

  public id?: number;
  private habilidadAux: Habilities = {
    id: 0,
    name: ''
  };
  public habilidades: Habilities[] = [];
  public rolFilter: ReplaySubject<Habilities[]> = new ReplaySubject<Habilities[]>(1);
  public form: FormGroup;
  dataSource = new MatTableDataSource<Habilities>(this.habilidades);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  public displayedColumns: string[] = [
    'Id',
    'Nombre',
    'Opciones'
  ];

  constructor(
    private formsBuilder: FormBuilder,
    private habilitiesService: HabilitiesService,
    private dialog: MatDialog,
    private matSnackbarService: MatSnackbarService
  ){}

  ngOnInit(): void {
    this.form = this.formsBuilder.group({
      nombre: '',
    });
    this.consultarHabilidades();
  }

  resetForm() {
    this.form.reset();
    this.consultarHabilidades();
  }

  buscarPorNombre() {
    this.consultarHabilidadesPorNombre(this.form.controls['nombre'].value);
  }

  consultarHabilidades(): void {
    this.habilitiesService.consultarListaHabilidades().subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<Habilities>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarHabilidadesPorNombre(nombre: string): void {
    this.habilitiesService.consultarListaHabilidadesPorNombre(nombre).subscribe(req => {
      if (req) {
        console.log(req);
        
        this.dataSource = new MatTableDataSource<Habilities>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  guardarHabilidad(): void{
    let habilidad: Habilities = {
      name: this.habilidadAux.name,
    };
    this.habilitiesService.guardarHabilidad(habilidad).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Habilidad ${habilidad.name} creada con exito`, "Cerrar");
        this.consultarHabilidades();
      }
    })
  }

  modificarHabilidad(habilidad: Habilities): void{
    this.habilitiesService.modificarHabilidad(habilidad).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Habilidad ${habilidad.name} modiicada con exito`, "Cerrar");
        this.consultarHabilidades();
      }
    })
  }

  eliminarHabilidad(habilidad: Habilities): void{
    console.log(habilidad.id);
    
    this.habilitiesService.eliminarHabilidad(Number(habilidad.id)).subscribe(req => {
      if(req){
        console.log(req);
        
        this.matSnackbarService.openSnackBar(`Habilidad ${habilidad.name} eliminada con exito`, "Cerrar");
        this.consultarHabilidades();
      }
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreateHabilitieComponent, {
      data: { 
        name: "", 
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      this.habilidadAux.name = result.name;
      this.guardarHabilidad();
    });
  }

  openModifyDialog(habilidadParam: Habilities): void {
    const dialogRef = this.dialog.open(ModifiyHabilitieComponent, {
      data: { 
        id: habilidadParam.id,
        name: habilidadParam.name
      },
      
    });

    dialogRef.afterClosed().subscribe(result => {
      this.habilidadAux.id = result.id;
      this.habilidadAux.name = result.name;
      this.modificarHabilidad(this.habilidadAux);
    });
  }
}
