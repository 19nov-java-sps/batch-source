import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private url = "https://jsonplaceholder.typicode.com/users";

  getUser() {
    return this.http.get(this.url).toPromise();
  }
}
