// Chemin : src/app/models/liste-course.model.ts

export class ListeCourse {
    utilisateurId: number;
    ingredients: string[];
  
    constructor(utilisateurId: number, ingredients: string[]) {
      this.utilisateurId = utilisateurId;
      this.ingredients = ingredients;
    }
  }
  