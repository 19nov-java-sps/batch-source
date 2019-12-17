import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  user: User = {
    id: 1,
    name: "John Doe",
    age: 27
  }
  text: string = "Show";
  display() {
    if (this.text === "Show") {
      this.text = "Hide"
    } else {
      this.text = "Show";
    }
  }
}
