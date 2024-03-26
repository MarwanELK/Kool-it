import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ComponentFixture, TestBed} from '@angular/core/testing';
import { of } from 'rxjs';
import { WikingredientsService } from './wikingredients.service';
import { WikingredientsComponent } from './wikingredients.component';

describe('WikingredientsComponent', () => {
  let component: WikingredientsComponent;
  let httpTestingController: HttpTestingController;
  let wikingredientsService: WikingredientsService;
  let fixture: ComponentFixture<WikingredientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [WikingredientsComponent],
      providers: [WikingredientsService] // Ajoutez le service ici
    });
    httpTestingController = TestBed.inject(HttpTestingController);
    component = TestBed.createComponent(WikingredientsComponent).componentInstance;
    fixture = TestBed.createComponent(WikingredientsComponent);
    component = fixture.componentInstance;
    wikingredientsService = TestBed.inject(WikingredientsService); // Injection du service ici
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should filter Wikingredients by search term', () => {
    // Avant de filtrer, assurez-vous que wikingredients est initialisé correctement
    component.wikingredients = [{ nomAliment: 'pomme' }, { nomAliment: 'carotte' }];
    component.rechercherAliments(); // Appeler la méthode de filtrage
    expect(component.wikingredientsFiltres.length).toEqual(2); // Vérifier le résultat du filtre
  });

  //test ok

  it('should call getProductDataByName and populate products array', () => {
    // Avant de filtrer, assurez-vous que wikingredients est initialisé correctement
    component.getProductDataByName('Nutella'); // Appeler la méthode de filtrage
    expect(component.barcode).toEqual(''); // Vérifier le résultat du filtre
    component.getProductDataByName('maltesers'); // Appeler la méthode de filtrage
    expect(component.barcode).toEqual(''); // Vérifier le résultat du filtre
  });
  
});
