import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { ProduitsComponent } from './produits/produits.component';
import { AproposComponent } from './apropos/apropos.component';
import { ContactComponent } from './contact/contact.component';
import { ProduitsListComponent } from './produits-list/produits-list.component';
import { ListeDeCoursesComponent } from './liste-de-courses/liste-de-courses.component';
import { MagasinsComponent } from './magasins/magasins.component';
import { MapComponent } from './map/map.component';

const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: 'apropos', component: AproposComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'produits-list', component: ProduitsListComponent }, 
  { path: 'liste-de-courses', component: ListeDeCoursesComponent },
  { path: 'Magasins', component: MagasinsComponent },
  { path: 'map', component: MapComponent},
  { path: '', redirectTo: '/accueil', pathMatch: 'full' },
  { path: '**', redirectTo: '/accueil' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
