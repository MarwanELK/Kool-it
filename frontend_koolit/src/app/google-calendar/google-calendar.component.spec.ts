import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleCalendarComponent } from './google-calendar.component';

describe('GoogleCalendarComponent', () => {
  let component: GoogleCalendarComponent;
  let fixture: ComponentFixture<GoogleCalendarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GoogleCalendarComponent]
    });
    fixture = TestBed.createComponent(GoogleCalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
