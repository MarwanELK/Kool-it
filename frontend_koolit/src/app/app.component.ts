import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // Vous pouvez ajouter des propriétés ou des méthodes ici si nécessaire

  // Par exemple, si vous voulez exécuter une action lors de l'initialisation de l'application
  ngOnInit() {
    console.log('Application initialized');
  }
}
