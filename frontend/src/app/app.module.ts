import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
// material
import {
  MdButtonModule,
  MdMenuModule,
  MdIconModule,
  MdToolbarModule,
  MdTooltipModule,
  MdCardModule,
  MdInputModule,
  MdIconRegistry,
  MdTableModule,
  MdProgressSpinnerModule
} from '@angular/material';

import { AppRoutingModule } from './app-routing.module';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CdkTableModule} from '@angular/cdk';


//flex layout
import { FlexLayoutModule } from '@angular/flex-layout';



// import service
import { RestaurantService } from './restaurant/restaurant.service';
import { ApiService, AuthService, ConfigService} from './shared/';
import { UserService } from './user/user.service';

// import component
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurant/restaurant-detail/restaurant-detail.component';
import { HomeComponent } from './home/home.component';
import { CommentComponent } from './comment/comment.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';
import { AccountMenuComponent } from './header/account-menu/account-menu.component';
import { LoginComponent } from './login/login.component';

//import guards
import { GuestGuard } from './guard/guest.guard';
import { LoginGuard } from './guard/login.guard';
import { AdminGuard } from './guard/admin.guard';

export function initUserFactory(userService: UserService) {
    return () => userService.initUser();
}


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    RestaurantComponent,
    RestaurantDetailComponent,
    HomeComponent,
    CommentComponent,
    UserComponent,
    AdminComponent,
    AccountMenuComponent,
    LoginComponent
  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    MdMenuModule,
    MdTooltipModule,
    MdButtonModule,
    MdIconModule,
    MdInputModule,
    MdToolbarModule,
    MdCardModule,
    MdProgressSpinnerModule,
    FlexLayoutModule,
    CdkTableModule,
    MdTableModule
  ],
  providers: [
    GuestGuard,
    LoginGuard,
    AdminGuard,
    RestaurantService,
    ApiService,  
    AuthService,  
    UserService, 
    ConfigService, 
    MdIconRegistry,
    {
      'provide': APP_INITIALIZER,
      'useFactory': initUserFactory,
      'deps': [UserService],
      'multi': true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
