import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateHabilitieComponent } from './create-habilitie.component';

describe('CreateHabilitieComponent', () => {
  let component: CreateHabilitieComponent;
  let fixture: ComponentFixture<CreateHabilitieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateHabilitieComponent]
    });
    fixture = TestBed.createComponent(CreateHabilitieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
