import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  colors: string[] = ['red', 'green', 'blue', 'yellow', 'purple'];

  selectedColor: string;

  constructor() { }

  ngOnInit() {
  }

}
