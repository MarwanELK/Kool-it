// produits.component.ts
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { KoolitService } from './koolit.service';
import { Commentaire } from '../model/recette.model';
import { Location } from '@angular/common';


@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];
  nouveauCommentaire: Commentaire={commentaireId:0, username: '', contenu: '' };

  constructor(private recetteService: RecetteService, private koolitService: KoolitService, private location: Location) {}

  ngOnInit(): void {
    const utilisateurId = 5;
    this.chargerListeDeCourses(utilisateurId);

    this.recetteService.getRecettes().subscribe(
      (data: any) => {
        console.log('Données de recettes reçues du backend :', data);
        this.recettes = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des recettes :', error);
      }
    );
  }

  envoyerCommentaire(recetteId: number): void {
    const nouveauCommentaireAEnvoyer = this.nouveauCommentaire;
    this.recetteService.enregistrerCommentaire(nouveauCommentaireAEnvoyer).subscribe(
      (response: any) => {
        console.log('Commentaire ajouté avec succès dans la base de données:', response);
        
        const recetteIndex = this.recettes.findIndex((recette) => recette.recetteId === recetteId);
        if (recetteIndex !== -1) {
          this.recettes[recetteIndex].commentaires.push(nouveauCommentaireAEnvoyer);
        }
        
        // Rafraîchir la liste après l'ajout
        this.chargerListeDeCourses(5); // Fournir l'ID de l'utilisateur ici
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du commentaire dans la base de données :', error);
      }
    );
    this.recetteService.envoyerCommentaire(recetteId,nouveauCommentaireAEnvoyer).subscribe(
      (response: any) => {
        console.log('Commentaire ajouté avec succès dans la base de données:', response);
        // Rafraîchir la liste après l'ajout
        this.chargerListeDeCourses(5); // Fournir l'ID de l'utilisateur ici
      },
      (error) => {
        console.error('Erreur lors de l\'ajout du commentaire dans la base de données :', error);
      }
    );
        
    this.nouveauCommentaire = {commentaireId:0, username: '', contenu: '' };
  }

  supprimerCommentaire(recetteId:number, commentaireId: number): void {
    this.recetteService.supprimerCommentaire(recetteId, commentaireId).subscribe(
      () => {
        console.log('Commentaire supprimé avec succès.');
        // Rafraîchir la liste après la suppression
        this.chargerListeDeCourses(5);
        const recetteIndex = this.recettes.findIndex((recette) => recette.recetteId === recetteId);
      if (recetteIndex !== -1) {
        const commentaireIndex = this.recettes[recetteIndex].commentaires.findIndex(
          (commentaire:any) => commentaire.commentaireId === commentaireId
        );

        if (commentaireIndex !== -1) {
          this.recettes[recetteIndex].commentaires.splice(commentaireIndex, 1);
        }
      }

      },
      (error) => {
        console.error('Erreur lors de la suppression du commentaire :', error);
      }
    );
  }



  ajouterALaListeDeCourses(ingredient: any): void {
   
    const ingredientAEnvoyer = {
      nom: ingredient.nom,
      quantite: ingredient.quantite,
      type: ingredient.type,
    };
  
    const nouvelleListe = {
      utilisateurId: 5,  
      ingredients: JSON.stringify([ingredientAEnvoyer]),
    };
  
    this.koolitService.ajouterIngredient(5, nouvelleListe).subscribe(
      (response: any) => {
        console.log('Ingrédient ajouté avec succès dans la base de données :', response);
       
        this.chargerListeDeCourses(5); 
      },
      (error) => {
        console.error('Erreur lors de l\'ajout de l\'ingrédient dans la base de données :', error);
      }
    );
  }
  ajouterTousALaListeDeCourses(recette: any): void {
    for (const ingredient of recette.ingredients) {
      this.ajouterALaListeDeCourses(ingredient);
    }
  }
  trierParNote(): void {
    this.recettes.sort((a, b) => b.note - a.note);
  }
 
  private chargerListeDeCourses(utilisateurId: number): void {
    this.koolitService.getListeDeCourses(utilisateurId).subscribe(
      (listeCoursesData: any[]) => {
        console.log('[Produit] Données de la liste de courses reçues du backend :', listeCoursesData);
        
      },
      (error) => {
        console.error('[Produit] Erreur lors de la récupération de la liste de courses :', error);
      }
    );
  }
  noterRecette(recette: any, note: number): void {
    this.recetteService.noterRecette(recette.recetteId, note).subscribe(
      (recetteNotee: any) => {
        console.log('Recette notée avec succès :', recetteNotee);
        // Rafraîchissez les données si nécessaire
        this.chargerListeDeCourses(5); // Assurez-vous d'ajuster cela en fonction de votre logique
      },
      (error: any) => { // Ajouter un type pour 'error'
        console.error('Erreur lors de la notation de la recette :', error);
      }
    );
}

augmenterPart(recette : any, personnesEnPlus:any):void{
  this.recetteService.augmenterPart(recette.recetteId, recette.personnesEnPlus).subscribe(
    (recetteNotee: any) => {
      console.log('Nombre de personnes augmenté avec succès :', recetteNotee);
      // Rafraîchissez les données si nécessaire
      this.chargerListeDeCourses(5); // Assurez-vous d'ajuster cela en fonction de votre logique
      window.location.reload();// recharger page
    },
    (error: any) => { // Ajouter un type pour 'error'
      console.error('Erreur lors de l augmentation du nombre de personne :', error);
    }
  );
}


}
