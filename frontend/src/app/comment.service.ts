import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ConfigService} from "./config.service";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private http: HttpClient) { }

  private extractData(res: Response) {
    const body = res;
    return body || {};
  }

  getComments(qualifier: string): Observable<any> {
    return this.http.get(ConfigService.getServerAddress() + 'api/comment/' + qualifier)
               .pipe(
      map(this.extractData));
  }
}
