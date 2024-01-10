// produits.component.ts

import { Component, OnInit } from '@angular/core';
import { RecetteService } from './recette.service';
import { KoolitService } from './koolit.service';
import { Commentaire } from '../model/recette.model';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
  
})
export class ProduitsComponent implements OnInit {
  recettes: any[] = [];
  nouveauCommentaire: { username: string, contenu: string } = { username: '', contenu: '' };

  constructor(private recetteService: RecetteService, private koolitService: KoolitService) {}

  ngOnInit(): void {
    this.recetteService.getRecettes().subscribe(
      (data: any) => {
        console.log('Données de recettes reçues du backend :', data);
        // Ajoutez la propriété isSelected à chaque recette
        this.recettes = data.map((recette: any) => ({ ...recette, isSelected: false }));
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

  ajouterTousALaListeDeCourses1(): void {
    const ingredientsListe: any[] = [];
  
    // Vérifier si au moins une recette est sélectionnée
    const auMoinsUneRecetteSelectionnee = this.recettes.some(recette => recette.isSelected);
  
    if (!auMoinsUneRecetteSelectionnee) {
      console.log('Aucune recette sélectionnée pour ajouter à la liste de courses.');
      return;
    }
  
    this.recettes
      .filter(recette => recette.isSelected)
      .forEach(recette => {
        ingredientsListe.push(
          ...recette.ingredients.map((ingredient: any) => ({
            nom: ingredient.nom,
            quantite: ingredient.quantite,
            type: ingredient.type,
          }))
        );
      });
  
    this.koolitService.ajouterIngredient(5, { ingredients: JSON.stringify(ingredientsListe) }).subscribe(
      (response) => {
        console.log('Ingrédients ajoutés avec succès dans la base de données.');
        this.chargerListeDeCourses(5);
      },
      (error: any) => {
        console.error('Erreur lors de l\'ajout des ingrédients dans la base de données :', error);
      }
    );
  }

  toggleSelection(recette: any): void {
    recette.isSelected = !recette.isSelected;
    console.log('Recette sélectionnée:', recette.isSelected);
  }

  trierParNote(): void {
    this.recettes.sort((a, b) => b.note - a.note);
  }

  private chargerListeDeCourses(utilisateurId: number): void {
    this.koolitService.getListeDeCourses(utilisateurId).subscribe(
      (listeCoursesData: any[]) => {
        console.log('Données de la liste de courses reçues du backend :', listeCoursesData);
        // Ajoutez du code pour mettre à jour votre interface utilisateur avec les données reçues
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
        this.chargerListeDeCourses(5);
      },
      (error: any) => {
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

  augmenterPart(recette: any, personnesEnPlus: any): void {
    this.recetteService.augmenterPart(recette.recetteId, recette.personnesEnPlus).subscribe(
      (recetteNotee: any) => {
        console.log('Nombre de personnes augmenté avec succès :', recetteNotee);
        // Rafraîchissez les données si nécessaire
        this.chargerListeDeCourses(5);
      },
      (error: any) => {
        console.error('Erreur lors de l augmentation du nombre de personne :', error);
      }
    );
  }
}
