import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-s-directives',
  templateUrl: './s-directives.component.html',
  styleUrls: ['./s-directives.component.css']
})
export class SDirectivesComponent implements OnInit {

  condition: boolean = true;
  time: string = 'day';

  // cats = [];

  cats = [{
    id: 32,
    color: "black",
    name: "Luna"
  },{
    id: 35,
    color: "orange",
    name: "Chips"
  },{
    id: 51,
    color: "white",
    name: "Snow"
  }, {
    id: 53,
    color: "gray",
    name: "Hobbs"
  }]

  constructor() { }

  ngOnInit() {
  }

  changeCondition(){
    this.condition = !this.condition;
  }

}
