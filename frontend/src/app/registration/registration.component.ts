import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserauthService} from '../userauth.service';
import {Router} from '@angular/router';
import {ConfigService} from '../config.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  username: string;
  password: string;
  passconfirm: string;
  email: string;
  data: any;
  errors: string;

  constructor(public http: HttpClient, public auth: UserauthService, public router: Router) {
    if (this.auth.isLoggedIn()) {
      router.navigate(['/home']);
    }
  }

  ngOnInit() {
  }

  register() {
    if (this.username == null || this.username.length < 3) {
      this.errors = 'Имя пользователя должно быть не короче 3 символов.';
    } else if (this.username.length > 24) {
      this.errors = 'Имя пользователя должно быть не длинее 24 символов.';
    } else if (this.password.length < 6) {
      this.errors = 'Пароль должен быть не короче 6 символов.';
    } else if (this.password !== this.passconfirm) {
      this.errors = 'Пароли не совпадают.';
    } else {
      this.http.post(ConfigService.getServerAddress() + 'api/user', JSON.stringify({name: this.username, password: this.password}),
        {headers: {'Content-Type': 'application/json;charset=UTF-8'}}).subscribe(data => {
          this.auth.setJustRegistered(true);
          this.router.navigate(['/login']);
      }, err => {
          this.errors = "Ошибка регистрации";
      });
    }
  }
}
