import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoggingService } from './logging.service';
import { Observable } from 'rxjs';
import { Post } from '../models/Post';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  url: string = 'https://jsonplaceholder.typicode.com/posts';

  constructor(private http: HttpClient, private logger: LoggingService) { }

  getPosts(): Observable<Post[]> {
    this.logger.log('getting all posts')
    return this.http.get<Post[]>(this.url);
  }

  getPostById(idParam: number){
    this.logger.log('fetching post with id: '+ idParam);
    return this.http.get<Post>(this.url+"/"+idParam).toPromise();
  }



}
