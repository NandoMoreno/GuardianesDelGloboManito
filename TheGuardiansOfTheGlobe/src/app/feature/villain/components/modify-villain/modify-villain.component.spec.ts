import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyVillainComponent } from './modify-villain.component';

describe('ModifyVillainComponent', () => {
  let component: ModifyVillainComponent;
  let fixture: ComponentFixture<ModifyVillainComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyVillainComponent]
    });
    fixture = TestBed.createComponent(ModifyVillainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
