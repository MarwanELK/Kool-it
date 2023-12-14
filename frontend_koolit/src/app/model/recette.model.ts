// recette.model.ts
export interface Recette {
    nom: string;
    ingredients: { nom: string, type: string }[];
    note: number;
    photoPath: string;
  }
  