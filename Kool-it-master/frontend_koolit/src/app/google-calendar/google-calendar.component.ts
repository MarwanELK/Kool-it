import { Component, OnInit } from '@angular/core';
import { KoolitService } from './koolit.service';
import { gapi } from 'gapi-script';

@Component({
  selector: 'app-google-calendar',
  templateUrl: './google-calendar.component.html',
  styleUrls: ['./google-calendar.component.css']
})
export class GoogleCalendarComponent implements OnInit {
  accessToken: string | null = null;

  constructor(private koolitService: KoolitService) {}

  ngOnInit(): void {
    gapi.load('client:auth2', this.initGoogleApi);
  }

  initGoogleApi = () => {
    gapi.client.init({
      apiKey: 'AIzaSyCCcWc_jtYhm19ParTFoPf_10xfct1l2yg',
      discoveryDocs: ['https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest'],
      scope: 'https://www.googleapis.com/auth/calendar'
    }).then(() => {
      gapi.auth2.getAuthInstance().isSignedIn.listen(this.updateSigninStatus);
      this.updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
    });
  };

  updateSigninStatus = (isSignedIn: boolean) => {
    if (isSignedIn) {
      this.accessToken = gapi.auth2.getAuthInstance().currentUser.get().getAuthResponse().access_token;
    } else {
      this.accessToken = null;
    }
  };

  handleAuthClick = () => {
    gapi.auth2.getAuthInstance().signIn();
  };

  insertEventAndRedirect() {
    if (this.accessToken) {
      this.koolitService.insertEvent(this.accessToken, '954582597122-culbj6alb423i7bjr0sile2j47ttq8dt.apps.googleusercontent.com').subscribe((response) => {
        console.log('Event inserted successfully:', response);
        // Rediriger l'utilisateur vers Google Calendar après avoir inséré l'événement
        window.open('https://calendar.google.com/', '_blank');
      }, (error) => {
        console.error('Error inserting event:', error);
      });
    } else {
      console.error('Access token not found');
    }
  }
}
