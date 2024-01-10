import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoutiqueDetailComponent } from './boutique-detail.component';

describe('BoutiqueDetailComponent', () => {
  let component: BoutiqueDetailComponent;
  let fixture: ComponentFixture<BoutiqueDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BoutiqueDetailComponent]
    });
    fixture = TestBed.createComponent(BoutiqueDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
