import { TestBed } from '@angular/core/testing';

import { DebilitiesService } from './debilities.service';

describe('DebilitiesService', () => {
  let service: DebilitiesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DebilitiesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
