import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HabilitiesListComponent } from './habilities-list.component';

describe('HabilitiesListComponent', () => {
  let component: HabilitiesListComponent;
  let fixture: ComponentFixture<HabilitiesListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HabilitiesListComponent]
    });
    fixture = TestBed.createComponent(HabilitiesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
