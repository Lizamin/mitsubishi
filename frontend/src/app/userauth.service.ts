import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import {CookieService} from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserauthService {

  token: string | null = null;
  username: string;
  admin: boolean = false;
  justRegistered: boolean = false;

  constructor(public cookieService: CookieService, private router: Router) {
    const cusername: string = cookieService.get('username');
    const caccesstoken: string = cookieService.get('access_token');
    const is_admin: string = cookieService.get('is_admin');
    if (cusername !== '') {
      this.username = cusername;
      this.token = caccesstoken;
      this.admin = JSON.parse(is_admin);
    }
  }

  getHttpAuthOptions(): any {
    if ( this.username != null && this.token != null) {
      return {Authorization: this.token};
    }
    return {};
  }

  getJsonHttpAuthOptions(): any {
    if ( this.token != null) {
      return {'Content-Type' : 'application/json', 'Authorization' : this.token};
    }
    return {'Content-Type' : 'application/json'};
  }

  login(name: string, token: string, admin: boolean): void {
    this.username = name;
    this.token = token;
    this.admin = admin;
    this.cookieService.set('username', this.username);
    this.cookieService.set('access_token', this.token);
    this.cookieService.set('is_admin', admin.toString());
  }

  isLoggedIn(): boolean {
    return this.token != null;
  }

  isAdmin(): boolean {
    return this.admin;
  }

  getUserName(): string {
    return this.username;
  }

  logout(): void {
    this.cookieService.set('username', '');
    this.cookieService.set('access_token', '');
    this.username = null;
    this.token = null;
  }

  isJustRegistered(): boolean {
    return this.justRegistered;
  }

  setJustRegistered(r: boolean): void {
    this.justRegistered = r;
  }
}
