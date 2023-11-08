import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnyKindComponent } from './any-kind.component';

describe('AnyKindComponent', () => {
  let component: AnyKindComponent;
  let fixture: ComponentFixture<AnyKindComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AnyKindComponent]
    });
    fixture = TestBed.createComponent(AnyKindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
