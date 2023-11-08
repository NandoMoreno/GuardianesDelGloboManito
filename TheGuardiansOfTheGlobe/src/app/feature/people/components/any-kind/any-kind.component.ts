import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { People } from '../../model/people';
import { PeopleService } from '../../service/people.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HabilitiesService } from 'src/app/feature/habilities/service/habilities.service';
import { Habilities } from 'src/app/feature/habilities/model/habilities';
import { HeroesService } from 'src/app/feature/heroes/service/heroes.service';
import { Heroes } from 'src/app/feature/heroes/model/heroes';
import { MatSnackbarService } from 'src/app/core/service/mat-snackbar.service';

@Component({
  selector: 'app-any-kind',
  templateUrl: './any-kind.component.html',
  styleUrls: ['./any-kind.component.css']
})
export class AnyKindComponent {

  public personaSeleccion: People;
  public personaBusqueda: People;
  public habilidadInicial: Habilities;
  
  public personas: People[];
  public habilidades: Habilities[] = [];
  
  public persona: any = this.data.persona;
  public opcion: any;
  public aporte: number;
  
  public formHeroe: FormGroup;
  public formVillano: FormGroup;
  public formPatrocinador: FormGroup;

  constructor(
    public dialogRef: MatDialogRef<AnyKindComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private peopleService: PeopleService,
    private habilitiesService: HabilitiesService,
    private heroService: HeroesService,
    private formsBuilder: FormBuilder,
    private matSnack: MatSnackbarService
  ) {}
  
  ngOnInit(): void {
    this.formHeroe = this.formsBuilder.group({
      persona: '',
      habilidad: '',
    });
    this.formVillano = this.formsBuilder.group({
      persona: '',
      habilidad: '',
      debilidad: '',
    });
    this.formPatrocinador = this.formsBuilder.group({
      persona: '',
      hereoPatrocinado: '',
      monto: '',
      procedencia: ''
    });
    this.opcion = this.data.opcion;
    this.consultarPersonas();
    this.consultarHabilidades();
  }

  consultarPersonas(): void {
    this.peopleService.consultarListaPersonas().subscribe(req => {
      if (req) {
        this.personas = req;
      }
    })
  }

  consultarHabilidades(): void {
    this.habilitiesService.consultarListaHabilidades().subscribe(req => {
      if (req) {
        this.habilidades = req;
      }
    })
  }

  consultarPersonasPorNombre(nombre: string): void {
    this.peopleService.consultarListaPersonasPorNombre(nombre).subscribe(req => {
      if (req) {
        this.personaBusqueda = req[0];
        console.log(this.personaBusqueda);
        
      }
    })
  }

  guardar(): void{
    console.log(this.personaSeleccion);
    console.log(this.habilidadInicial);

    switch (this.opcion) {
      case "Heroe":
        let heroe: Heroes = {
          wins: 0,
          peopleId: this.personaSeleccion.id,
          hability:  this.habilidadInicial.id 
        }
        console.log(heroe);
        
        this.heroService.guardarHeroe(heroe).subscribe(req => {
          if(req){
            this.matSnack.openSnackBar("Heroe " + this.personaSeleccion.name + "creado con exito", "Cerrar");
          }
        })
        console.log("Toco heroe yeeja");
        break;
      case "Villano":
          console.log("Veo pase el bicho no se haga dañar");
          break;
      case "Patrocinador":
        console.log("Ya ni le muevas papi");
        break;
      default:
        break;
    }
    
  }
  onNoClick(): void {
    this.dialogRef.close();
  }
}
