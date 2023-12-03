import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { ListeDeCoursesComponent } from './liste-de-courses/liste-de-courses.component';
import { RecettesComponent } from './recettes/recettes.component';


const routes: Routes = [
  { path: 'root', component: AppComponent },
  {path: 'recettes', component: RecettesComponent},
  { path: 'liste-de-courses', component: ListeDeCoursesComponent },
  // ... d'autres routes
];

@NgModule({
  declarations: [
    AppComponent,
    ListeDeCoursesComponent,
    RecettesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }


