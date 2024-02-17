import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // Importez HttpClientTestingModule
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importez FormsModule
import { ListeDeCoursesComponent } from './liste-de-courses.component';


describe('ListeDeCoursesComponent', () => {
  let component: ListeDeCoursesComponent;
  let fixture: ComponentFixture<ListeDeCoursesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListeDeCoursesComponent],
      imports: [HttpClientTestingModule, CommonModule,FormsModule]
    });
    fixture = TestBed.createComponent(ListeDeCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
