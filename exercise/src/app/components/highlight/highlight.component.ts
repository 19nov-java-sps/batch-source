import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  colors: string[] = ['red', 'green', 'blue'];

  constructor() { }

  ngOnInit() {
  }

}
