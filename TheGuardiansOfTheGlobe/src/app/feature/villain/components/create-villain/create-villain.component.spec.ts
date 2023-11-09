import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVillainComponent } from './create-villain.component';

describe('CreateVillainComponent', () => {
  let component: CreateVillainComponent;
  let fixture: ComponentFixture<CreateVillainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateVillainComponent]
    });
    fixture = TestBed.createComponent(CreateVillainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
