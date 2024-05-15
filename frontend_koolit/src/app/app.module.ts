import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ProduitsComponent } from './produits/produits.component';
import { AproposComponent } from './apropos/apropos.component';
import { ContactComponent } from './contact/contact.component';
import { HttpClientModule } from '@angular/common/http';
import { ProduitsListComponent } from './produits-list/produits-list.component';
import { ListeDeCoursesComponent } from './liste-de-courses/liste-de-courses.component';
import { MagasinsComponent } from './magasins/magasins.component';
import { WikingredientsComponent } from './wikingredients/wikingredients.component';
import { MapComponent } from './map/map.component';
import { GoogleCalendarComponent } from './google-calendar/google-calendar.component';
import { SocialLoginModule, SocialAuthServiceConfig } from 'angularx-social-login';
import { GoogleLoginProvider } from 'angularx-social-login';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ProduitsComponent,
    AproposComponent,
    ContactComponent,
    ProduitsListComponent,
    ListeDeCoursesComponent,
    MagasinsComponent,
    MapComponent,
     WikingredientsComponent,
     GoogleCalendarComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider('954582597122-culbj6alb423i7bjr0sile2j47ttq8dt.apps.googleusercontent.com')
          }
        ]
      } as SocialAuthServiceConfig
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
