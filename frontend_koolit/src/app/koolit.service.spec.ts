import { TestBed } from '@angular/core/testing';

import { KoolitService } from './koolit.service';

describe('KoolitService', () => {
  let service: KoolitService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KoolitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
