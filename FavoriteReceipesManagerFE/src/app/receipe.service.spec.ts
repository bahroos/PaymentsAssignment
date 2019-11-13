import { TestBed } from '@angular/core/testing';

import { ReceipeService } from './receipe.service';

describe('ReceipeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReceipeService = TestBed.get(ReceipeService);
    expect(service).toBeTruthy();
  });
});
