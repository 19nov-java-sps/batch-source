import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  people = [
    {
      name: "adonis cabreja",
      email: "adonis@gmail.com",
      birthday: new Date("June 25 1995")
    },
    {
      name: "john doe",
      email: "john@gmail.com",
      birthday: new Date("July 2 1980")
    },
    {
      name: "jane doe",
      email: "jane@gmail.com",
      birthday: new Date("January 27 1982")
    }
  ]

  isStyled: boolean = true;
  buttonText: string = "Without Bootstrap";

  changeStyle() {
    if (this.buttonText === "Without Bootstrap") {
      this.buttonText = "With Bootstrap";
      this.isStyled = false;
    } else {
      this.buttonText = "Without Bootstrap";
      this.isStyled = true;
    }
  }
}
