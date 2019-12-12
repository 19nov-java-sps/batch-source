import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = ['cat', 'dog', 'bird'];
  colors: string[] = ['red', 'green', 'blue'];
  days: string[] = ['Monday', 'Wednesday', 'Friday'];

  selected: string;

  constructor() { }

  ngOnInit() {
  }
  
}
