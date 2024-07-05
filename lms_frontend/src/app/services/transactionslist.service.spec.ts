import { TestBed } from '@angular/core/testing';

import { TransactionslistService } from './transactionslist.service';

describe('TransactionslistService', () => {
  let service: TransactionslistService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionslistService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
