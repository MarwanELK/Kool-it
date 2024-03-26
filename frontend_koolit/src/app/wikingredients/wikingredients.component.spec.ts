import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // Importez HttpClientTestingModule
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importez FormsModule
import { WikingredientsComponent } from './wikingredients.component';

describe('WikingredientsComponent', () => {
  let component: WikingredientsComponent;
  let fixture: ComponentFixture<WikingredientsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WikingredientsComponent],
      imports: [HttpClientTestingModule, CommonModule,FormsModule]
    });
    fixture = TestBed.createComponent(WikingredientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
