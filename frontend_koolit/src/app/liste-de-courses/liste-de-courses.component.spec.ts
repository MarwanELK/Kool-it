import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDeCoursesComponent } from './liste-de-courses.component';

describe('ListeDeCoursesComponent', () => {
  let component: ListeDeCoursesComponent;
  let fixture: ComponentFixture<ListeDeCoursesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListeDeCoursesComponent]
    });
    fixture = TestBed.createComponent(ListeDeCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
