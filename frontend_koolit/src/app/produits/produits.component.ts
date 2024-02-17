// produits.component.ts
import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { KoolitService } from './koolit.service';
import { Commentaire } from '../model/recette.model';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css']
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];
  nouveauCommentaire: { username: string, contenu: string } = { username: '', contenu: '' };
  constructor(private recetteService: RecetteService, private koolitService: KoolitService) {}

  ngOnInit(): void {
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
        console.log('Données de la liste de courses reçues du backend :', listeCoursesData);
        
      },
      (error) => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
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
envoyerCommentaire(recette: any): void {
  if (this.nouveauCommentaire.username.trim() !== '' && this.nouveauCommentaire.contenu.trim() !== '') {
    // Créez un objet Commentaire
    const commentaire: Commentaire = {
      username: this.nouveauCommentaire.username,
      contenu: this.nouveauCommentaire.contenu
    };

    // Ajoutez le commentaire à la liste de commentaires de la recette
    recette.commentaires.push(commentaire);

    // Appelez le service pour envoyer le commentaire au backend
    this.recetteService.envoyerCommentaire(recette.recetteId, commentaire).subscribe(
      (recetteMiseAJour: any) => {
        // Mise à jour de la recette dans la liste
        const index = this.recettes.findIndex(r => r.recetteId === recetteMiseAJour.recetteId);
        if (index !== -1) {
          this.recettes[index] = recetteMiseAJour;
        }
      },
      (error) => {
        console.error('Erreur lors de l\'envoi du commentaire à la recette :', error);
      }
    );

    // Réinitialisez le formulaire de commentaire
    this.nouveauCommentaire = { username: '', contenu: '' };
  } else {
    console.warn('Le commentaire ou le nom d\'utilisateur est vide. Veuillez saisir les deux.');
  }
}
augmenterPart(recette : any, personnesEnPlus:any):void{
  this.recetteService.augmenterPart(recette.recetteId, recette.personnesEnPlus).subscribe(
    (recetteNotee: any) => {
      console.log('Nombre de personnes augmenté avec succès :', recetteNotee);
      // Rafraîchissez les données si nécessaire
      this.chargerListeDeCourses(5); // Assurez-vous d'ajuster cela en fonction de votre logique
    },
    (error: any) => { // Ajouter un type pour 'error'
      console.error('Erreur lors de l augmentation du nombre de personne :', error);
    }
  );
}

}