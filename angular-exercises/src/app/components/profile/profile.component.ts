import { Component, OnInit } from '@angular/core';
import { Profile } from '../../models/profile';



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})


export class ProfileComponent implements OnInit {
    
  title:string = 'Profile Component';

  id:Profile;

  ngOnInit() {
       
  }

  constructor() {

    this.id = {
      name: 'KWAME MARTIN',
      age: 33,
      gender: 'MALE',
      country: 'TRINIDAD & TOBAGO',
      job: 'SOFTWARE ENGINEER',
      company: 'REVATURE'
    }
   }

  text: string = "SHOW";
  display() {
    if (this.text === "SHOW") {
      this.text = "HIDE"
    } else {
      this.text = "SHOW";
    }
  }


  

}
