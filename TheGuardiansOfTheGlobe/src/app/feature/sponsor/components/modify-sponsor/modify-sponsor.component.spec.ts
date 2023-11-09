import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifySponsorComponent } from './modify-sponsor.component';

describe('ModifySponsorComponent', () => {
  let component: ModifySponsorComponent;
  let fixture: ComponentFixture<ModifySponsorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModifySponsorComponent]
    });
    fixture = TestBed.createComponent(ModifySponsorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
