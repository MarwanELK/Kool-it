import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import { KoolitService } from './koolit.service';
import { Ingredient } from '../model/ingredient.model';


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit{
  map: any;
  magasins: any[]=[];
  magasin : any = {
    nom:'',
    typeMagasin:'',
    ville:'',
    urlMagasin:'',
    typeAliment:'',
    listesCourses: []
  };
  ville: any = {
    nom:'Nanterre',
    lat:48.9010513,
    lng:2.2133626
  };

  smallIcon = new L.Icon({
    iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-icon.png',
    iconRetinaUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-icon-2x.png',
    iconSize:    [25, 41],
    iconAnchor:  [12, 41],
    popupAnchor: [1, -34],
    shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    shadowSize:  [41, 41]
  });
  magasinSelectionne: any = {};
  nomMagasinRecherche: string = '';
  nouvelIngredient: Ingredient = { id: 0, nom: '', quantite:0, type: '', ingredients: [] }; // Ajoutez 'id' ici
  listesCourses: Ingredient[] = [];
  ListeDeLC: any[]=[];
  mesCourses : any[]=[];
  utilisateurId = 5;

  constructor(private koolitService: KoolitService) { }

  ngAfterViewInit(): void {
    this.getMagasinsParVille(this.ville.nom); // faire une super fonction qui appel les autres fonction
    //this.createMap();
    //this.chargerMagasins();
  }

  rechercheParCoords(lat:number, lng:number){
    this.koolitService.getVilleParCoords(lat,lng).subscribe(
      (data)=> {
        if(data!=null){
          this.ville = data;
          console.log('Données de la ville :', this.ville);
          this.map.off(); // Désactivez tous les gestionnaires d'événements sur la carte
          this.map.remove(); // Supprimez la carte actuelle
          this.getMagasinsParVille(this.ville.nom);
        }else{
          this.ville.nom='';
          this.ville.lat=lat;
          this.ville.lng=lng;
          this.map.off(); // Désactivez tous les gestionnaires d'événements sur la carte
          this.map.remove(); // Supprimez la carte actuelle
          this.createMap();
        }
      },
      (error) => {
        console.error('Erreur lors de la récupération des données de la ville :', error);
      }
    );
  }

  rechercheParVille(nomVille: string){
    this.koolitService.getVilleParNom(nomVille).subscribe(
      (data)=> {
        this.ville = data;
        console.log('Données de la ville :', this.ville);
        this.map.off(); // Désactivez tous les gestionnaires d'événements sur la carte
        this.map.remove(); // Supprimez la carte actuelle
        this.getMagasinsParVille(nomVille);
      },
      (error) => {
        console.error('Erreur lors de la récupération des données de la ville :', error);
      }
    );
  }

  getMagasinsParVille(ville:string){
    this.koolitService.getMagasinsParVille(ville).subscribe(
      (data) => {
        this.magasins = data;
        console.log('Données des magasins :', this.magasins);
        this.createMap(); // Appel à une fonction d'initialisation de la carte
      },
      (error) => {
        console.error('Erreur lors de la récupération des données des magasins :', error);
      }
    );
    this.koolitService.getMagasinsParVille(ville).subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', magasinsData);
        this.magasins = magasinsData.map((magasin) => ({
          nom: magasin.nom,
          type: magasin.typeMagasin,
          ville: magasin.ville,
          url: magasin.urlMagasin,
          typeAliment: magasin.typeAliment
        }));
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );
    this.koolitService.getMagasinsParVille(ville).subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', magasinsData);
        this.magasins = magasinsData;
        this.chargerListeDeCourses(5);
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );    
  }

  createMap(){
    const zoomLevel = 12;

    
    this.map = L.map('map',{
      center: [this.ville.lat, this.ville.lng],
      zoom: zoomLevel
    });
    

    const mainLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      minZoom: 14, //dezoomer (jusqu'à map monde)
      maxZoom: 20, //augmenter capacité du zoom
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    });

    mainLayer.addTo(this.map);
    this.addMarker(this.magasins); // separer du reste
    
  }

  addMarker(magasins:any[]){
    this.magasins.forEach((magasin) => {
      const marker = L.marker([magasin.lat, magasin.lng], {icon:this.smallIcon}); //
      const lien = `<a href="http://localhost:4200/magasins" target="_blank">${magasin.nom}</a>`;
      const boutton = document.createElement('button');
        boutton.innerHTML = magasin.nom;
        boutton.addEventListener('click', () => this.rechercherMagasin(magasin.nom));
      marker.addTo(this.map).bindPopup(boutton); //.openPopupun() un seul popup ouvert a la fois 
    });
  }

  //Version alternative !!!!!!!!
   addMarker2({coords1,coords2,text1,text2,open} : any){ //
    const marker1 = L.marker([coords1.lat, coords1.lng], {icon:this.smallIcon}); //
    if(open){ //
      marker1.addTo(this.map).bindPopup(text1).openPopup(); //
    }else{ //
      marker1.addTo(this.map).bindPopup(text1); //
    } //
    const marker2 = L.marker([coords2.lat, coords2.lng], {icon:this.smallIcon}); //
    marker2.addTo(this.map).bindPopup(text2).openPopup(); //
  } //

  rechercherMagasin(nom:string): void {
     // Vérifier si la barre de recherche est vide
  if (!this.nomMagasinRecherche.trim()) {
    this.koolitService.getMagasinsParVille(this.ville.nom).subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', magasinsData);
        this.magasins = magasinsData.map((magasin) => ({
          nom: magasin.nom,
          type: magasin.typeMagasin,
          ville: magasin.ville,
          url: magasin.urlMagasin,
          typeAliment: magasin.typeAliment
        }));
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );
  }else{
    this.koolitService.rechercherMagasinParNom(nom,this.ville.nom).subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', nom);
        this.magasins = magasinsData.map((magasin) => ({
          nom: magasin.nom,
          type: magasin.typeMagasin,
          ville: magasin.ville,
          url: magasin.urlMagasin,
          typeAliment: magasin.typeAliment
        }));
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );
  }
}
  selectionnerMagasin(magasin: any): void {
    // Affectez la valeur du magasin sélectionné
    this.magasinSelectionne = magasin;
  }

  private chargerListeDeCourses(utilisateurId: number): void {
    this.koolitService.getListeDeCourses(utilisateurId).subscribe(
      (listeCoursesData: any[]) => {
        console.log('listeCourseData :', listeCoursesData);
        for (let i = 0; i < this.magasins.length; i++) {
          this.magasin=this.magasins[i];
          this.listesCourses = listeCoursesData
        .map((course) => {
          course.ingredientsList = JSON.parse(course.ingredients);
          return course;
        }).filter((course) => course.ingredientsList?.[0].type === this.magasin.typeAliment);
        console.log('Je suis numero :', i,"/5");
        this.ListeDeLC.push(this.listesCourses);
        }
        this.ElemLdcParMagasin();
      },
      (error) => {
        console.error('Erreur lors de la récupération de la liste de courses :', error);
      }
    );
  }

  ElemLdcParMagasin():void{
    for (let i = 0; i < this.magasins.length; i++) {
      this.magasin=this.magasins[i];
      this.magasin.listesCourses=this.ListeDeLC[i];
      this.magasins[i]=this.magasin;
    }
    console.log('listesCourses Marwan ok :', this.listesCourses); //.filter((course) => course.ingredientsList?.[0].type === "Sucré");
  }

  supprimerIngredient(ingredientId: number): void {
    this.koolitService.supprimerIngredient(ingredientId).subscribe(
      () => {
        console.log('Ingrédient supprimé avec succès.');
        // Rafraîchir la liste après la suppression
        this.chargerListeDeCourses(5);
      },
      (error) => {
        console.error('Erreur lors de la suppression de l\'ingrédient :', error);
      }
    );
  }

  /*FicheMagasin(nom:string): void {
    this.koolitService.ficheMagasin(nom).subscribe(
      (magasinsData: any[]) => {
        console.log('Données des magasins reçues du backend :', nom);
        this.magasins =magasinsData;
      },
      (error) => {
        console.error('Erreur lors de la récupération des magasins :', error);
      }
    );
  }*/

}
