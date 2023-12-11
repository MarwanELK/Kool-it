import { Component, OnInit } from '@angular/core';
import {KoolitService} from '../koolit.service'

@Component({
  selector: 'app-liste-de-courses',
  templateUrl: './liste-de-courses.component.html',
  styleUrls: ['./liste-de-courses.component.css'],
  providers:[KoolitService]
})


export class ListeDeCoursesComponent implements OnInit{
  title = 'frontend_koolit';
  listeDeCourses: any = []

  constructor(private koolitService : KoolitService){

  }

  ngOnInit() : void {
    console.log('On init....')
    this.koolitService.getListeDeCourses().subscribe((datas)=>{
      this.listeDeCourses=datas;
    })
  }
}