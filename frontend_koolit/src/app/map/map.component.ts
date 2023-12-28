import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit{
  map: any;

  smallIcon = new L.Icon({
    iconUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-icon.png',
    iconRetinaUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-icon-2x.png',
    iconSize:    [25, 41],
    iconAnchor:  [12, 41],
    popupAnchor: [1, -34],
    shadowUrl: 'https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png',
    shadowSize:  [41, 41]
  });

  constructor() { }

  ngAfterViewInit(): void {
    this.createMap();
  }

  createMap(){
    const gal_la_fay = {
      lat: 48.8736459,
      lng: 2.3321271,
    };
    const printemps ={
      lat: 48.8739230,
      lng: 2.328092,
    }
    const zoomLevel = 12;
    this.map = L.map('map',{
      center: [gal_la_fay.lat, gal_la_fay.lng],
      zoom: zoomLevel
    });

    const mainLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      minZoom: 12, //dezoomer (jusqu'à map monde)
      maxZoom: 20, //augmenter capacité du zoom
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    });

    mainLayer.addTo(this.map);
    const descriptionWikipediaGLF = `
    Les Galeries Lafayette sont une enseigne de grands magasins,
    appartenant au groupe Galeries Lafayette,
    qui est membre de l'Association Internationale des Grands Magasins depuis 1960.
    `;
    const descriptionWikipediaPRTMPS = `
    Le Printemps est une entreprise française exploitante de grands magasins,
    qui se positionne principalement sur des marques de mode, de luxe et de beauté. 
    Le Printemps est également l'un des leaders français des listes de mariage.
    `;
    const popupOption ={
      coords1 : gal_la_fay,
      coords2 : printemps,
      text1: descriptionWikipediaGLF,
      text2: descriptionWikipediaPRTMPS,
      open : true
    }
    this.addMarker(popupOption);
    
  }

  addMarker(option:any){
    const marker1 = L.marker([option.coords1.lat, option.coords1.lng], {icon:this.smallIcon});
    if(option.open){
      marker1.addTo(this.map).bindPopup(option.text1).openPopup(); //un seul popup ouvert a la fois 
    }else{
      marker1.addTo(this.map).bindPopup(option.text1);
    }
    const marker2 = L.marker([option.coords2.lat, option.coords2.lng], {icon:this.smallIcon});
    marker2.addTo(this.map).bindPopup(option.text2);
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
