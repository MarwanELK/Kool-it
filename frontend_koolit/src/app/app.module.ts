import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
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
import { CommonModule } from '@angular/common';


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
    WikingredientsComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    CommonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule {}
