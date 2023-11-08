import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifiyHabilitieComponent } from './modifiy-habilitie.component';

describe('ModifiyHabilitieComponent', () => {
  let component: ModifiyHabilitieComponent;
  let fixture: ComponentFixture<ModifiyHabilitieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifiyHabilitieComponent]
    });
    fixture = TestBed.createComponent(ModifiyHabilitieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
