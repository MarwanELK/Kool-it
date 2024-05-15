import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // Importez HttpClientTestingModule
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importez FormsModule
import { MagasinsComponent } from './magasins.component';

describe('MagasinsComponent', () => {
  let component: MagasinsComponent;
  let fixture: ComponentFixture<MagasinsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MagasinsComponent],
      imports: [HttpClientTestingModule, CommonModule,FormsModule]
    });
    fixture = TestBed.createComponent(MagasinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
