import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserauthService} from "./userauth.service";
import {Observable} from "rxjs";
import {ConfigService} from "./config.service";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private http: HttpClient, private userAuthService: UserauthService) { }

  private extractData(res: Response) {
    const body = res;
    return body || {};
  }

  getArticles(): Observable<any> {
    return this.http.get(ConfigService.getServerAddress() + 'api/article', {headers: this.userAuthService.getHttpAuthOptions()}).pipe(
      map(this.extractData));
  }
}
