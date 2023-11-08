import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DebilitiesListComponent } from './debilities-list.component';

describe('DebilitiesListComponent', () => {
  let component: DebilitiesListComponent;
  let fixture: ComponentFixture<DebilitiesListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DebilitiesListComponent]
    });
    fixture = TestBed.createComponent(DebilitiesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
