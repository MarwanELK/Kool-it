export interface Ingredient {
    id: number; // Ajoutez cette ligne
    nom: string;
    type: string;
    quantite:number
    ingredients: { nom: string, quantite: number, type: string }[];
    ingredientsList?: { nom: string, quantite:number, type: string }[];
  }