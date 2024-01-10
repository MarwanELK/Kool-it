import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
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
import { BoutiqueDetailComponent } from './boutique/boutique-detail/boutique-detail.component';
import { ArticleListComponent } from './boutique/article-list/article-list.component';


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
    BoutiqueDetailComponent,
    ArticleListComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
