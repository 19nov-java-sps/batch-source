import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/Person';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  people: Person[] = [{
    firstName: 'first1',
    lastName: 'last1',
    email: 'abc@gmail.com',
    birthday: new Date()
  }, {
    firstName: 'first2',
    lastName: 'last2',
    email: 'def@gmail.com',
    birthday: new Date()
  }, {
    firstName: 'first3',
    lastName: 'last3',
    email: 'ghi@gmail.com',
    birthday: new Date()
  },];

  constructor() { }

  ngOnInit() {
  }

}
