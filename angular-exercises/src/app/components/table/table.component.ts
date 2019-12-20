import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  title:string = "TABLE COMPONENT";


  employees = [
    
    {
    firstName: "Kwame",
    lastName: "Martin",
    email: "kwame.martin.j@gmail.com",
    birthday: "09/06/1986"
  },{
    firstName: "Peter",
    lastName: "Nguyen",
    email: "peter.nguyen@gmail.com",
    birthday: "08/12/1990"
  },{
    firstName: "Ryan",
    lastName: "Carstons",
    email: "ryan.carstons@gmail.com",
    birthday: "03/09/1996"
  }, {
    firstName: "Jason",
    lastName: "Yang",
    email: "jason.yang@gmail.com",
    birthday: "02/08/1998"
  },{
    firstName: "Adonis",
    lastName: "Cabreja",
    email: "adonis.cabreja@gmail.com",
    birthday: "05/03/1995"
  }
]

  constructor() { }

  ngOnInit() {
  }

  isStyled:boolean = false;
  buttonName:string = "CLICK THIS BUTTON TO SEE THE UNFORMATTED TABLE";

  changeStyle() {

    //change the name of the button
    if(this.buttonName === "CLICK THIS BUTTON TO SEE THE UNFORMATTED TABLE") {
      this.buttonName = "CLICK THIS BUTTON TO SEE THE FORMATTED TABLE";
      this.isStyled = false;
    }
    else{
      this.buttonName = "CLICK THIS BUTTON TO SEE THE UNFORMATTED TABLE";
      this.isStyled = true;
    }    
  }
}
