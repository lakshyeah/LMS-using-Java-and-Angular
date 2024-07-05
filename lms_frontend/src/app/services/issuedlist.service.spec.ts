import { TestBed } from '@angular/core/testing';

import { IssuedlistService } from './issuedlist.service';

describe('IssuedlistService', () => {
  let service: IssuedlistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IssuedlistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
