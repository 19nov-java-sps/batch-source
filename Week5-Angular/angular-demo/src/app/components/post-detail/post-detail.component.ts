import { Component, OnInit } from '@angular/core';
import { LoggingService } from 'src/app/services/logging.service';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/models/Post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {

  currentPost: Post = new Post();

  constructor(private logger: LoggingService, private route: ActivatedRoute, private postService:PostService) { }

  ngOnInit() {
    this.route.params.subscribe(param=>{
      this.currentPost.id = param['id'];
      this.logger.log('path param: '+ this.currentPost.id);
      this.getPost(this.currentPost.id);
    })
  }

  getPost(idParam: number){
    this.postService.getPostById(idParam)
      .then((responsePost)=>{
        this.currentPost = responsePost;
      })
      .catch((e)=>{
        this.logger.warn(e);
      })
  }

}
