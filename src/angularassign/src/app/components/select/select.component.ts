import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = ['cat', 'dog', 'tiger'];
  colors: string[] = ['red', 'yellow', 'green'];
  days: string[] = ['Friday', 'Saturday', 'Sunday'];

  selected: string;

  constructor() { }

  ngOnInit() {
  }

}
