import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/Profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  show: boolean = true;

  profile: Profile = {
    id: 1,
    name: 'Jon',
    jobtitle: 'Developer'
  };

  constructor() { }

  ngOnInit() {
  }

  showhide(){
    this.show = !this.show;
  }
}
