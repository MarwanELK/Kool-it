import { Component, OnInit } from '@angular/core';
import { KoolitService } from '../koolit.service';

@Component({
  selector: 'app-produits-list',
  templateUrl: './produits-list.component.html',
  styleUrls: ['./produits-list.component.css']
})
export class ProduitsListComponent implements OnInit {
  recettes: any[] = [];

  constructor(private koolitService: KoolitService) { }

  ngOnInit(): void {
    this.koolitService.getRecettes().subscribe((data) => {
      this.recettes = data;
    });
  }
}
