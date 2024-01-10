// boutique-detail.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BoutiqueService } from '../boutique.service';
import { Boutique } from '../boutique.model';

@Component({
  selector: 'app-boutique-detail',
  templateUrl: './boutique-detail.component.html',
  styleUrls: ['./boutique-detail.component.css']
})
export class BoutiqueDetailComponent implements OnInit {
  boutique: Boutique | undefined;

  constructor(
    private route: ActivatedRoute,
    private boutiqueService: BoutiqueService
  ) {}


ngOnInit(): void {
  this.getBoutiqueDetails();
}

getBoutiqueDetails(): void {
  const idParam = this.route.snapshot.paramMap.get('id');

  if (idParam !== null) {
    const id = +idParam;
    console.log('ID:', id);

    this.boutiqueService.getBoutiqueById(id).subscribe(
      boutique => {
        this.boutique = boutique;
        console.log('Boutique:', boutique);
      },
      error => {
        console.error('Error fetching boutique details:', error);
        // Gérer l'erreur, par exemple, rediriger vers une page d'erreur.
      }
    );
  } else {
    console.error('ID is null. Handle this case appropriately.');

    // Gérer le cas où 'id' est null, par exemple, rediriger vers une page d'erreur.
  }
}


}