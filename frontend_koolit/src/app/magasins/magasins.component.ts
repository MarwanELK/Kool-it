import { Component, OnInit } from '@angular/core';
import { KoolitService } from './koolit.service';
import { Observable } from 'rxjs'; 

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

  
  ajouterTypeAliment(magasin: any): void {
    // Assurez-vous que le magasin sélectionné et le nouveau type d'aliment sont définis
    if (magasin.nom && this.nouveauTypeAliment) {
      // Utilisez la méthode du service pour ajouter un type d'aliment
      this.koolitService.ajouterTypeAliment(magasin.nom, this.nouveauTypeAliment).subscribe(
        (response: any) => {
          console.log('Type d\'aliment ajouté avec succès dans la base de données :', response);
          // Rafraîchir la liste après l'ajout
          this.chargerMagasins();
          // Réinitialiser le champ du nouveau type d'aliment
          this.nouveauTypeAliment = '';
        },
        (error) => {
          console.error('Erreur lors de l\'ajout du type d\'aliment dans la base de données :', error);
        }
      );
    } else {
      console.error('Veuillez sélectionner un magasin et spécifier un nouveau type d\'aliment.');
    }
  }


selectionnerMagasin(magasin: any): void {
  if (this.magasinSelectionne === magasin) {
      
      this.magasinSelectionne = {};
  } else {
     
      this.magasinSelectionne = magasin;
  }
}


}
