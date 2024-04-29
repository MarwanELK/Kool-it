import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; 
import { KoolitService } from './koolit.service';

describe('KoolitService', () => {
  let service: KoolitService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], // Importez les modules nécessaires
      providers: [KoolitService] // Ajoutez le service dans le tableau providers
    });
    service = TestBed.inject(KoolitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
