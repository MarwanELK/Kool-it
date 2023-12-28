import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import { KoolitService } from './koolit.service';


@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit{
  map: any;
  magasins: any[]=[];
  ville: any;
  NanterreUniversite = {
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

  constructor(private koolitService: KoolitService) { }

  ngAfterViewInit(): void {
    this.getMagasinsParVille(this.NanterreUniversite.nom,true); // faire une super fonction qui appel les autres fonction
    //this.createMap();
  }

  rechercheParVille(nomVille: string){
    this.koolitService.getVilleParNom(nomVille).subscribe(
      (data)=> {
        this.ville = data;
        console.log('Données de la ville :', this.ville);
        this.map.off(); // Désactivez tous les gestionnaires d'événements sur la carte
        this.map.remove(); // Supprimez la carte actuelle
        this.getMagasinsParVille(nomVille,false);
        //this.createMap('ok'); // Créez une nouvelle carte avec les nouvelles données de la ville et des magasins
      },
      (error) => {
        console.error('Erreur lors de la récupération des données de la ville :', error);
      }
    );
  }

  getMagasinsParVille(ville:string,first:boolean){
    this.koolitService.getMagasinsParVille(ville).subscribe(
      (data) => {
        this.magasins = data;
        console.log('Données des magasins :', this.magasins);
        this.createMap(first); // Appel à une fonction d'initialisation de la carte
      },
      (error) => {
        console.error('Erreur lors de la récupération des données des magasins :', error);
      }
    );
  }

  createMap(first:boolean){
    const zoomLevel = 12;

    if(first){
      this.map = L.map('map',{
        center: [this.NanterreUniversite.lat, this.NanterreUniversite.lng],
        zoom: zoomLevel
      });
    }else{
      console.log('je sui dans le else', this.ville);
      console.log('lat de la ville :', this.ville.lat);
      this.map = L.map('map',{
        center: [this.ville.lat, this.ville.lng],
        zoom: zoomLevel
      });
    }
    

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
      marker.addTo(this.map).bindPopup(magasin.nom); //.openPopupun() un seul popup ouvert a la fois 
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

}
