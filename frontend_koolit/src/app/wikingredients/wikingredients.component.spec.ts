import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WikingredientsComponent } from './wikingredients.component';

describe('WikingredientsComponent', () => {
  let component: WikingredientsComponent;
  let fixture: ComponentFixture<WikingredientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WikingredientsComponent]
    });
    fixture = TestBed.createComponent(WikingredientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
