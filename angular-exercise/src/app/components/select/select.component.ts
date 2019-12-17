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

  animals = ["Dog", "Cat", "Tiger", "Lion"];
  colors = ["Blue", "Red", "Black", "Green"];
  days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
}
