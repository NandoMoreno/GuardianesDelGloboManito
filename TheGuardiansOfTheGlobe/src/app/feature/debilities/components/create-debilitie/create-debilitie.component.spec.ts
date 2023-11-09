import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDebilitieComponent } from './create-debilitie.component';

describe('CreateDebilitieComponent', () => {
  let component: CreateDebilitieComponent;
  let fixture: ComponentFixture<CreateDebilitieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateDebilitieComponent]
    });
    fixture = TestBed.createComponent(CreateDebilitieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
