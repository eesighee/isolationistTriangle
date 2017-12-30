import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './types/user.type';
import { environment } from '../environments/environment';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class LoginService implements CanActivate {

  public loginSubject = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient, private router: Router) {
    var u = localStorage.getItem("user");
    if (u) this.loginSubject.next(JSON.parse(u));
  }

  usernameAvailable(username: string): Observable<boolean> {
    return this.http.post<boolean>(environment.API_URL + "/login/username", [username]);
  }

  emailAvailable(email: string): Observable<boolean> {
    return this.http.post<boolean>(environment.API_URL + "/login/email", [email]);
  }

  addUser(user: User) {
    this.http.post<User>(environment.API_URL + "/login/register", user)
      .subscribe(u => {
        this.loginSubject.next(u);
        localStorage.setItem("user", JSON.stringify(u));
      }, err => {
        this.loginSubject.next(null);
      });
  }

  login(username: string, password: string) {
    this.http.post<User>(environment.API_URL + "/login", [username, password])
      .subscribe(u => {
        this.loginSubject.next(u);
        localStorage.setItem("user", JSON.stringify(u));
      }, err => {
        this.loginSubject.next(null);
      });
  }
  

  logout() {
    this.loginSubject.next(null);
    localStorage.removeItem("user");
    this.router.navigate(["login"]);
  }

  canActivate() {
    if (this.loginSubject.getValue() == null) {
      this.router.navigate(["login"]);
      return false;
    } else return true;
  }

}
