import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'https://jsonplaceholder.typicode.com/users';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Object[]> {
    return this.http.get<Object[]>(this.url);
  }

  getUserById(idParam: number) {
    return this.http.get<Object>(this.url+"/"+idParam).toPromise();
  }

}
