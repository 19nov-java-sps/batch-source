import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count:number = 0;
  counterColorClass: string = "blue-text";

  constructor() { }

  ngOnInit() {
  }

  increment(value: number){
    this.count += value;
    if(this.count%5==0){
      this.counterColorClass = "red-text";
    } else {
      this.counterColorClass = "blue-text";
    }
  }

}
