export interface Recette {
  recetteId:number;
  nom: string;
  ingredients: { nom: string, quantite:number, type: string }[];
  note: number;
  commentaires: Commentaire[];
  photoPath: string;
}

export interface Commentaire {
  commentaireId:number;
  username: string;
  contenu: string;
}