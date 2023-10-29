import { Component } from '@angular/core';

//import {KoolitService} from './koolit.service'

import {OnInit} from '@angular/core'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  //providers:[KoolitService]
})
export class AppComponent {
  title = 'frontend_koolit';
 /* recettes: Object={}

  constructor(private koolitService : KoolitService){

  }

  ngOnInit(){
    console.log('On init....')
    this.koolitService.getRecettes().subscribe((datas)=>{
      this.recettes=datas;
    })
  }*/
}
