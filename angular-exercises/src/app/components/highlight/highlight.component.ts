import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  title:string = 'Highlight Component';
  text:string = "Hover your mouse cursor over this text.";
  isHovered: boolean;

  constructor() { }

  ngOnInit() {
  }

}
