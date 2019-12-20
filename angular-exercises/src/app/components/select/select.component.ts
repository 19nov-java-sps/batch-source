import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  
  constructor() { }

    ngOnInit() {

    }
  
    selectedAnimals: boolean = false;
    selectedColors: boolean = false;
    selectedDays: boolean = false;

  title:string = "SELECT COMPONENT";


  animals =["Dog", "Shark", "Rhino", "Lion"];
  days =["Friday", "Thursday", "Saturday"];
  colors =["Red", "Black", "Navy"];
}
