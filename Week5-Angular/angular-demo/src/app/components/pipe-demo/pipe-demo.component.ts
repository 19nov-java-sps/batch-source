import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.css']
})
export class PipeDemoComponent implements OnInit {

  str: string = "hello world";
  num: number = 25;
  day: Date = new Date();

  strArray: string[] = ['cAT', 'DoG', 'oTTEr', 'arCTic FOX', 'OCtopUS'];
  products: string[] = ['vanilla-yogurt', 'chocolate-pudding', 'oreo-cookies', 'fried-chicken'];

  constructor() { }

  ngOnInit() {
  }

}
