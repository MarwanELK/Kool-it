import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing'; // Importez HttpClientTestingModule
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; // Importez FormsModule
import { KoolitService } from './koolit.service';

describe('KoolitService', () => {
  let service: KoolitService;

  beforeEach(() => {
    TestBed.configureTestingModule({      imports: [HttpClientTestingModule, CommonModule,FormsModule]
    });
    service = TestBed.inject(KoolitService);
    
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
