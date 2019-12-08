import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-http-demo',
  templateUrl: './http-demo.component.html',
  styleUrls: ['./http-demo.component.css']
})
export class HttpDemoComponent implements OnInit {

  posts: Post[] = [];

  constructor(private postService: PostService) { }

  ngOnInit() {
  }

  getAllPosts(){
    //make a call to a service for the requested content and populate our post array with that content
    this.postService.getPosts()
      .subscribe((allPosts)=>{
        this.posts = allPosts;
      })

  }

}
