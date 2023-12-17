import { Component, OnInit } from '@angular/core';
import { KoolitService } from './koolit.service';
import { Observable } from 'rxjs';  // Importez Observable depuis rxjs

@Component({
  selector: 'app-magasins',
  templateUrl: './magasins.component.html',
  styleUrls: ['./styles.css']
})
export class MagasinsComponent implements OnInit {
  typeAlimentFiltre: string = '';
  nomMagasinRecherche: string = '';
  magasins: any[] = [];
  magasinSelectionne: any = {};
  nouveauTypeAliment: string = '';
  typesAliment: string[] = [];

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

  rechercherTypesAliment(): void {
    if (this.nomMagasinRecherche.trim() !== '') {
      this.koolitService.rechercherTypesAliment(this.nomMagasinRecherche).subscribe(
        (typesAliment: string[]) => {
          console.log('Résultats de la recherche de types d\'aliment :', typesAliment);
          // Mettez à jour la liste de types d'aliment dans votre composant
          this.typesAliment = typesAliment;
        },
        (error) => {
          console.error('Erreur lors de la recherche de types d\'aliment :', error);
        }
      );
    } else {
      this.chargerMagasins();
    }
  }
  selectionnerMagasin(magasin: any): void {
    // Affectez la valeur du magasin sélectionné
    this.magasinSelectionne = magasin;
  }
  filtrerMagasinsParTypeAliment(typeAliment: string): void {
    console.log('Filtrage par type d\'aliment :', typeAliment);
    if (typeAliment.trim() !== '') {
      this.magasins = this.magasins.filter(magasin => magasin.typeAliment.includes(typeAliment));
    } else {
      // Si le champ de recherche est vide, rechargez tous les magasins
      this.chargerMagasins();
    }
    console.log('Nouveaux magasins après filtrage :', this.magasins);
  }

ajouterTypeAliment(): void {
  if (this.magasinSelectionne && this.magasinSelectionne.nom && this.nouveauTypeAliment.trim() !== '') {
      // Utilisez this.magasinSelectionne pour accéder au magasin sélectionné
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
  } else {
      console.error('Magasin sélectionné non valide ou type d\'aliment vide.');
  }
}

  
  
}
