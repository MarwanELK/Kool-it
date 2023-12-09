import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MagasinsComponent } from './magasins.component';

describe('MagasinsComponent', () => {
  let component: MagasinsComponent;
  let fixture: ComponentFixture<MagasinsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MagasinsComponent]
    });
    fixture = TestBed.createComponent(MagasinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
