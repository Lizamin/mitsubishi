import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserauthService} from "../userauth.service";
import {CommentService} from "../comment.service";
import {ConfigService} from "../config.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrls: ['./adminpanel.component.css']
})
export class AdminpanelComponent implements OnInit {

  total_comments: number;

  constructor(public http: HttpClient, public auth: UserauthService, public router: Router) {
    if(!auth.isAdmin()){
      this.router.navigate(['/home']);
    }
  }

  ngOnInit() {
    this.http.get(ConfigService.getServerAddress() + 'api/statistics/comments',
      {headers: this.auth.getJsonHttpAuthOptions()}
    )
        .subscribe(data => {
          let stat: any = data;
          this.total_comments = stat.total_comments;
        });
  }

  isAdmin(): boolean {
    return this.auth.isAdmin();
  }
}
