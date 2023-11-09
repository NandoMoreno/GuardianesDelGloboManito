import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyDebilitieComponent } from './modify-debilitie.component';

describe('ModifyDebilitieComponent', () => {
  let component: ModifyDebilitieComponent;
  let fixture: ComponentFixture<ModifyDebilitieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyDebilitieComponent]
    });
    fixture = TestBed.createComponent(ModifyDebilitieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
