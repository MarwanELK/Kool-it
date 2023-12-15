// recette.model.ts
export interface Recette {
  nom: string;
  ingredients: { nom: string, quantite:number, type: string }[];
  note: number;
  photoPath: string;
}
