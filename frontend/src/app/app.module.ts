import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {LoginComponent} from './login/login.component';
import {CookieService} from 'ngx-cookie-service';
import {RegistrationComponent} from './registration/registration.component';
import {HomeComponent} from './home/home.component';
import {PanelComponent} from './panel/panel.component';
import {SlideshowModule} from "ng-simple-slideshow";
import { L200Component } from './l200/l200.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { CommentsComponent } from './comments/comments.component';
import { EclipseComponent } from './eclipse/eclipse.component';
import { AsxComponent } from './asx/asx.component';
import { OutlanderComponent } from './outlander/outlander.component';
import { PajerosportComponent } from './pajerosport/pajerosport.component';
import { PajeroComponent } from './pajero/pajero.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    RegistrationComponent,
    HomeComponent,
    PanelComponent,
    L200Component,
    CommentsComponent,
    EclipseComponent,
    AsxComponent,
    OutlanderComponent,
    PajerosportComponent,
    PajeroComponent,
    AdminpanelComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    SlideshowModule,
    NgbModule,
  ],
  providers: [ CookieService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
