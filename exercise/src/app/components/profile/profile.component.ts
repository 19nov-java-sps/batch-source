import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/Profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  visibility: boolean = true;
  myProfile: Profile = new Profile();

  constructor() { }

  ngOnInit() {
    this.myProfile.id = 3;
    this.myProfile.name = 'Jia Li';
  }

  changeVisibility(){
    this.visibility = !this.visibility;
  }
}
