import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyPeopleComponent } from './modify-people.component';

describe('ModifyPeopleComponent', () => {
  let component: ModifyPeopleComponent;
  let fixture: ComponentFixture<ModifyPeopleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyPeopleComponent]
    });
    fixture = TestBed.createComponent(ModifyPeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
