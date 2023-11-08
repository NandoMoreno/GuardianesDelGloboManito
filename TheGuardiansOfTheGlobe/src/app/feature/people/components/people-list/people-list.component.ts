import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { ReplaySubject, Subject } from 'rxjs';
import { People } from '../../model/people';
import { MatDialog } from '@angular/material/dialog';
import { PeopleService } from '../../service/people.service';
import { MatTableDataSource } from '@angular/material/table';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CreatePeopleComponent } from '../create-people/create-people.component';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';
import { ModifyPeopleComponent } from '../modify-people/modify-people.component';
import { AnyKindComponent } from '../any-kind/any-kind.component';

@Component({
  selector: 'app-people-list',
  templateUrl: './people-list.component.html',
  styleUrls: ['./people-list.component.css']
})
export class PeopleListComponent {

  public id?: number;
  private personaAux: People = {
    id: 0,
    name: 'John doe',
    ageRank: 'NuN'
  };
  public personas: People[] = [];
  public rolFilter: ReplaySubject<People[]> = new ReplaySubject<People[]>(1);
  public form: FormGroup;
  dataSource = new MatTableDataSource<People>(this.personas);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  public displayedColumns: string[] = [
    'Id',
    'Nombre',
    'Edad',
    'Rango De Edad',
    'Opciones'
  ];

  constructor(
    private formsBuilder: FormBuilder,
    private peopleService: PeopleService,
    private dialog: MatDialog,
    private matSnackbarService: MatSnackbarService
  ) { }

  ngOnInit(): void {
    this.form = this.formsBuilder.group({
      nombre: '',
      edad: '',
      rango: '',
    });
    this.consultarPersonas();
  }

  resetForm() {
    this.form.reset();
    this.consultarPersonas();
  }

  buscarPorNombre() {
    this.consultarPersonasPorNombre(this.form.controls['nombre'].value);
  }

  buscarPorEdad() {
    this.consultarPersonasPorEdad(this.form.controls['edad'].value);
  }

  buscarPorRango() {
    this.consultarPersonasPorRango(this.form.controls['rango'].value);
  }

  consultarPersonas(): void {
    this.peopleService.consultarListaPersonas().subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<People>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarPersonasPorNombre(nombre: string): void {
    this.peopleService.consultarListaPersonasPorNombre(nombre).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<People>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarPersonasPorEdad(edad: number): void {
    this.peopleService.consultarListaPersonasPorEdad(edad).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<People>(req);
        this.dataSource.paginator = this.paginator;
      }
    })
  }

  consultarPersonasPorRango(rango: string): void {
    this.peopleService.consultarListaPersonasPorRango(rango).subscribe(req => {
      if (req) {
        this.dataSource = new MatTableDataSource<People>(req);
        this.dataSource.paginator = this.paginator;
        console.log(req);
      }
    })
  }

  guardarPersona(): void{
    let persona: People = {
      name: this.personaAux.name,
      age: this.personaAux.age
    };
    this.peopleService.guardarPersona(persona).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Persona ${persona.name} creada con exito`, "Cerrar");
        this.consultarPersonas();
      }
    })
  }

  modificarPersona(persona: People): void{
    this.peopleService.modificarPersona(persona).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Persona ${persona.name} modiicada con exito`, "Cerrar");
        this.consultarPersonas();
      }
    })
  }

  eliminarPersona(persona: People): void{
    this.peopleService.eliminarPersona(Number(persona.id)).subscribe(req => {
      if(req){
        this.matSnackbarService.openSnackBar(`Persona ${persona.name} modiicada con exito`, "Cerrar");
        this.consultarPersonas();
      }
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(CreatePeopleComponent, {
      data: { 
        name: this.personaAux.name, 
        age: this.personaAux.age
      },
    });

    dialogRef.afterClosed().subscribe(result => {
      this.personaAux.name = result.name;
      this.personaAux.age = result.age;
      this.guardarPersona();
    });
  }

  openModifyDialog(personaParam: People): void {
    const dialogRef = this.dialog.open(ModifyPeopleComponent, {
      data: { 
        id: personaParam.id,
        name: personaParam.name, 
        age: personaParam.age
      },
      
    });

    dialogRef.afterClosed().subscribe(result => {
      this.personaAux.id = result.id;
      this.personaAux.name = result.name;
      this.personaAux.age = Number(result.age);
      this.modificarPersona(this.personaAux);
    });
  }

  anyKindDialog(opcion: string, color: string): void {
    const dialogRef = this.dialog.open(AnyKindComponent, {
      data: { 
        opcion: opcion,
        color: color
      },
      
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }
}

