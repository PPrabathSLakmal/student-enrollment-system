import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FormsModule, NgModel} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { LoginComponent } from './view/login/login.component';
import { SignupComponent } from './view/signup/signup.component';
import { HomeComponent } from './view/home/home.component';
import { DetailsComponent } from './view/details/details.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
export const routes:Routes = [
  {
    path:"",
    component:LoginComponent
  },
  {
    path:"signup",
    component:SignupComponent
  },
  {
    path:"home",
    component:HomeComponent,
    children: [
      {
          path: "details",
        component: DetailsComponent,
        outlet: "side-nav"
      }]
  },
  // {
  //   path: "home/details",
  //   component: DetailsComponent,
  //   outlet: "side-nav"
  // }
]
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    DetailsComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    MatSidenavModule,
    MatPaginatorModule,
    MatTableModule,
    MatButtonModule,
  ],
  providers: [],
  exports: [
    DetailsComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {


}
