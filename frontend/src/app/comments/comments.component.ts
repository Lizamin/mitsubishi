import {Component, Input, OnInit} from '@angular/core';
import {CommentService} from "../comment.service";
import {ConfigService} from "../config.service";
import {HttpClient} from "@angular/common/http";
import {UserauthService} from "../userauth.service";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  @Input('qualifier') qualifier: string;

  newCommentText: string;

  errors: string;

  comments: any;

  constructor(public http: HttpClient, public auth: UserauthService, public commentService: CommentService) {
  }

  ngOnInit() {
    this.loadComments();
  }

  makeComment() {
    this.http.post(ConfigService.getServerAddress() + 'api/comment/' + this.qualifier,
      JSON.stringify({text: this.newCommentText}),
      {headers: this.auth.getJsonHttpAuthOptions()}
    )
        .subscribe(data => {
          this.loadComments()
        }, err => {
          this.errors = "Произошел троллинг";
        });
  }

  isAuthorized(): boolean {
    return this.auth.isLoggedIn();
  }

  isAdmin(): boolean {
    return this.auth.isAdmin();
  }

  delete(id: number) {
    this.http.delete(ConfigService.getServerAddress() + 'api/comment/' + id,
      {headers: this.auth.getJsonHttpAuthOptions()}
    )
        .subscribe(data => {
          this.loadComments()
        });
  }

  loadComments() {
    this.commentService.getComments(this.qualifier)
        .subscribe(data => {
          this.comments = data;
        });
  }

}
