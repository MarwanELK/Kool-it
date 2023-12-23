// recette.model.ts
export interface Recette {
    nom: string;
    ingredients: { nom: string, quantite:number, type: string }[];
    note: number;
    commentaires: Commentaire[];
    photoPath: string;
  }
  
  export interface Commentaire {
    username: string;
    contenu: string;
  }