import { Component, OnInit } from '@angular/core';

import {KoolitService} from './koolit.service'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[KoolitService]
})
export class AppComponent implements OnInit{
  title = 'frontend_koolit';
  recettes: any = []

  constructor(private koolitService : KoolitService){

  }

  ngOnInit() : void {
    console.log('On init....')
    this.koolitService.getRecettes().subscribe((datas)=>{
      this.recettes=datas;
    })
  }
}
