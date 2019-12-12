import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-a-directives',
  templateUrl: './a-directives.component.html',
  styleUrls: ['./a-directives.component.css']
})
export class ADirectivesComponent implements OnInit {

  colors: string[] = ['blue', 'red', 'green'];
  formats: string[] = ['highlight', 'bold', 'italic'];
  selectedFormats: string[] = [];
  selectedColor: string;
  selectEnabled: false;

  constructor() { }

  ngOnInit() {
  }

  updateFormat(event){
    this.selectedFormats = [];
    let options = event.target.options;
    // console.log(options);
    for(let option of options){
      if(option.selected){
        this.selectedFormats.push(option.value);
      }
    }
    console.log(this.selectedFormats);
  }

}
