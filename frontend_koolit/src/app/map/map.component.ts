import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as L from 'leaflet';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements AfterViewInit{
  map: any;
  constructor() { }

  ngAfterViewInit(): void {
    this.createMap();
  }

  createMap(){
    const Paris = {
      lat: 48.8566,
      lng: 2.3522,
    };

    const zoomLevel = 12;
    this.map = L.map('map',{
      center: [Paris.lat, Paris.lng],
      zoom: zoomLevel
    });

    const mainLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      minZoom: 12, //dezoomer (jusqu'à map monde)
      maxZoom: 20, //augmenter capacité du zoom
      attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    });

    mainLayer.addTo(this.map);

  }
}