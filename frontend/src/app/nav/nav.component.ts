import {Component, OnInit} from '@angular/core';
import {UserauthService} from '../userauth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public userAuthService: UserauthService) {
  }

  ngOnInit() {
  }

  isLoggedIn(): boolean {
    return this.userAuthService.isLoggedIn();
  }

  getUserName(): string {
    return this.userAuthService.getUserName();
  }

  logout(): void {
    this.userAuthService.logout();
  }

  isAdmin(): boolean {
    return this.userAuthService.isAdmin();
  }

}
