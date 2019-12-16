import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  currentUserId: number;
  currentUser: User;

  constructor( private route: ActivatedRoute, private userService:UserService) { }

  ngOnInit() {
    this.route.params.subscribe(param => {
      this.currentUserId = param['id'];
      this.getUser(this.currentUserId);
    })
  }

  getUser(idParam: number){
    this.userService.getUserById(idParam)
      .then((responsePost)=>{
        this.currentUser = responsePost;
      })
      .catch((e)=>{
        console.warn(e);
      })
  }

}
