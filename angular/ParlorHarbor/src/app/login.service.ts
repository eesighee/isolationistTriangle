import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { User } from './types/user.type';

@Injectable()
export class LoginService {

  public loginSubject = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) { }

  //testing dataset
  users = [
    { username: "bob", email: "bob@gmail.com", password: "123" },
    { username: "alice", email: "alice@gmail.com", password: "456" },
    { username: "charlie", email: "charlie@gmail.com", password: "789" },
    { username: "diane", email: "diane@gmail.com", password: "abc" },
    { username: "elvis", email: "elvis@gmail.com", password: "ABC" },
  ];


  //All of these implementations are for testing until the backend is up
  usernameAvailable(username: string): boolean {
    return !this.users.some(u => u.username == username)
  }

  addUser(u: User) {
    this.users.push({ username: u.username, email: u.email, password: u.password });
    this.login(u.username, u.password);
  }

  emailAvailable(email: string): boolean{
    return !this.users.some(u => u.email == email)
  }

  login(username: string, password: string) {
    var user = this.users.filter(u => u.username == username && u.password == password);
    if (user) this.loginSubject.next(new User(user));
  }

  logout() {
    this.loginSubject.next(null);
  }

}
