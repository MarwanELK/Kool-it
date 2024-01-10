// boutique.model.ts
export interface Boutique {
    id?: number;
    name: string;
    description: string;
    articles: Article[];
  }
  
  export interface Article {
    id?: number;
    name: string;
    price: number;
  }
  