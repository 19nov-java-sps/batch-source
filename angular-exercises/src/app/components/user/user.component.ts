import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  title:string = "USER COMPONENT";

  constructor(private userService: UserService) { }

  users = [];

  ngOnInit() {  

      this.userService.getUser().then(response => {
      this.users = Object.values(response);
      console.log(this.users);
    })
  }

}
