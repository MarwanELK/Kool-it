import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { KoolitService } from '../koolit.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
declare var createGoogleEvent: any;


@Component({
  selector: 'app-google-calendar',
  templateUrl: './google-calendar.component.html',
  styleUrls: ['./google-calendar.component.css']
})
export class GoogleCalendarComponent {
  appointmentForm! : FormGroup;
  constructor(private router: Router, private koolitservice: KoolitService, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.appointmentForm = this.fb.group({
      eventName: ['', Validators.required],
      appointmentTime : ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  scheduleMeeting() {
    let appointmentTime = new Date(this.appointmentForm.value.appointmentTime);
    const startTime = appointmentTime.toISOString().slice(0, 18) + '+01:00';
    const endTime = this.getEndTime(appointmentTime);
    const eventDetails = {
      email: this.appointmentForm.value.email,
      startTime: startTime,
      endTime: endTime,
      summary: this.appointmentForm.value.eventName,
    };
    console.info(eventDetails);
    createGoogleEvent(eventDetails, (response: any) => {
      if (response && response.htmlLink) {
        alert('L\'événement a été ajouté avec succès !');
        window.open(response.htmlLink, '_blank');
      } else {
        console.error('Erreur lors de la création de l\'événement');
        alert('Une erreur s\'est produite lors de l\'ajout de l\'événement.');
      }
    });

  }
  getEndTime(appointmentTime: Date){
    appointmentTime.setHours(appointmentTime.getHours()+1);
    const endTime = appointmentTime.toISOString().slice(0,18) + '+01:00';
    return endTime;
  }

  

  redirectToGoogleCalendar() {
    window.open('https://calendar.google.com/calendar', '_blank');
  }
}
