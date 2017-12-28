import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from './types/user.type';
import { environment } from '../environments/environment';
import { CanActivate } from '@angular/router/src/interfaces';

@Injectable()
export class LoginService implements CanActivate{

  public loginSubject = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) { }

  usernameAvailable(username: string): Observable<boolean> {
    return this.http.post<boolean>(environment.API_URL + "/login/username", [username]);
  }

  emailAvailable(email: string): Observable<boolean> {
    return this.http.post<boolean>(environment.API_URL + "/login/email", [email]);
  }

  addUser(u: User) {
    this.http.post<User>(environment.API_URL + "/login/register", u).subscribe(us => {
      this.loginSubject.next(us);
    });
  }

  login(username: string, password: string) {
    this.http.post<User>(environment.API_URL + "/login", [username, password]).subscribe(u => {
      if (u) this.loginSubject.next(u);
    });
  }

  logout() {
    this.loginSubject.next(null);
  }

  canActivate() {
    return this.loginSubject.getValue() != null;
  }

}
