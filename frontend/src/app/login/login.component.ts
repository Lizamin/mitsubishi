import {Component, OnInit} from '@angular/core';
import {UserauthService} from '../userauth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Location} from '@angular/common';
import {Router} from '@angular/router';
import {ConfigService} from '../config.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  errors: string;

  constructor(public userService: UserauthService,
    public http: HttpClient,
    public location: Location,
    public router: Router) {
    if (this.userService.isLoggedIn()) {
      router.navigate(['/home']);
    }
  }

  ngOnInit() {
  }

  login(): void {
    const payload = new HttpParams()
      .set('username', this.username)
      .set('password', this.password);

    const httpOptions: any = {
      responseType: 'text'
    };

    this.http.post(ConfigService.getServerAddress() + 'login', payload, httpOptions)
        .subscribe(data => {
          this.errors = null;
          let val: any = data;
          let response = JSON.parse(val);
          this.userService.login(this.username, response.token, response.roles.includes("ADMIN"));
          if (this.userService.isJustRegistered()) {
            this.router.navigate(['/home']);
          } else {
            this.location.back();
          }
        }, err => {
          this.errors = 'Неверный логин или пароль.';
        });
  }

}
