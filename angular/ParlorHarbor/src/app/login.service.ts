import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { User } from './types/user.type';

@Injectable()
export class LoginService {

  loginSubject = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) { }

  usernameAvailable(username: string): boolean {
    //actually check
    return false;
  }

  emailAvailable(email: string): boolean{
    return false;
  }

  login(username: string, password: string) {
    var user = new User();
    //actually get the user
    this.loginSubject.next(user);
  }

  logout() {
    this.loginSubject.next(null);
  }

}
