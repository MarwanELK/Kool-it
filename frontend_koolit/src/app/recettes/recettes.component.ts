import { Component, OnInit } from '@angular/core';
import {KoolitService} from '../koolit.service'

@Component({
  selector: 'app-recettes',
  templateUrl: './recettes.component.html',
  styleUrls: ['./recettes.component.css'],
  providers:[KoolitService]
})
export class RecettesComponent implements OnInit{
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
