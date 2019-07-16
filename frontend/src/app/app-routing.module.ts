import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {L200Component} from "./l200/l200.component";
import {HomeComponent} from "./home/home.component";
import {EclipseComponent} from "./eclipse/eclipse.component";
import {AsxComponent} from "./asx/asx.component";
import {OutlanderComponent} from "./outlander/outlander.component";
import {PajerosportComponent} from "./pajerosport/pajerosport.component";
import {PajeroComponent} from "./pajero/pajero.component";
import {AdminpanelComponent} from "./adminpanel/adminpanel.component";

const routes: Routes = [
  { path: 'register', component: RegistrationComponent },
  { path: 'login', component: LoginComponent },
  { path: 'l200', component: L200Component },
  { path: 'eclipse', component: EclipseComponent },
  { path: 'asx', component: AsxComponent },
  { path: 'outlander', component: OutlanderComponent },
  { path: 'pajero_sport', component: PajerosportComponent },
  { path: 'pajero', component: PajeroComponent },
  { path: 'admin', component: AdminpanelComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
