import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  employees = [{
    fname: 'Jon',
    lname: 'Snow',
    email: 'JSnow@aol.com',
    birthday: '2/15/1991'
  },{
    fname: 'Joey',
    lname: 'Albert',
    email: 'JAlbert@aol.com',
    birthday: '9/15/1984'
  },{
    fname: 'Tony',
    lname: 'Stark',
    email: 'TStark@aol.com',
    birthday: '4/17/1984'
  }]

  constructor() { }

  ngOnInit() {
  }

}
