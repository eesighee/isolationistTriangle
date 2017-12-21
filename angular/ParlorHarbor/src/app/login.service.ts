import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class LoginService {

  loginSubject = new BehaviorSubject<User>(null);

  constructor(private http: HttpClient) { }

}
