import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; 
import { VetServiceService } from './vet-service.service';

describe('VetServiceService', () => {
  let service: VetServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule], // Importez les modules nécessaires
      providers: [VetServiceService] // Ajoutez le service dans le tableau providers
    });
    service = TestBed.inject(VetServiceService); // Utilisez TestBed.inject pour obtenir une instance du service
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
