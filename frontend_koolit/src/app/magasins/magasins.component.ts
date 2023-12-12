import { Component, OnInit } from '@angular/core';
import { KoolitService } from './koolit.service';
import { Observable } from 'rxjs';  // Importez Observable depuis rxjs

@Component({
  selector: 'app-magasins',
  templateUrl: './magasins.component.html',
  styleUrls: ['./styles.css']
})
export class MagasinsComponent implements OnInit {
  nomMagasinRecherche: string = '';
  magasins: any[] = [];
  magasinSelectionne: any = {};
  nouveauTypeAliment: string = '';

  constructor(private koolitService: KoolitService) { }

  ngOnInit(): void {
    this.chargerMagasins();
  }

  chargerMagasins(): void {
    this.koolitService.getMagasins().subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', magasinsData);
        this.magasins = magasinsData.map((magasin) => ({
          nom: magasin.nom,
          type: magasin.typeMagasin,
          url: magasin.urlMagasin,
          typeAliment: magasin.typeAliment
        }));
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );
  }

  rechercherMagasin(): void {
    if (this.nomMagasinRecherche.trim() !== '') {
      this.koolitService.rechercherMagasinParNom(this.nomMagasinRecherche).subscribe(
        (magasinsData: any[]) => {
          console.log('Résultats de la recherche :', magasinsData);
          this.magasins = magasinsData.map((magasin) => ({
            nom: magasin.nom,
            type: magasin.typeMagasin,
            url: magasin.urlMagasin,
            typeAliment: magasin.typeAliment
          }));
        },
        (error) => {
          console.error('Erreur lors de la recherche de magasin :', error);
        }
      );
    } else {
      // Si la barre de recherche est vide, rechargez tous les magasins
      this.chargerMagasins();
    }
  }

  ajouterTypeAliment(): void {
    // Utilisez la méthode du service pour ajouter un type d'aliment
    this.koolitService.ajouterTypeAliment(this.magasinSelectionne.nom, this.nouveauTypeAliment).subscribe(
      (response: any) => {
        console.log('Type d\'aliment ajouté avec succès dans la base de données :', response);
        // Rafraîchir la liste après l'ajout
        this.chargerMagasins();
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du type d\'aliment dans la base de données :', error);
      }
    );
  }
}
