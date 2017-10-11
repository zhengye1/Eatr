import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule, APP_INITIALIZER } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';
// material
import {
  MdAutocompleteModule,
  MdButtonModule,
  MdButtonToggleModule,
  MdCardModule,
  MdCheckboxModule,
  MdChipsModule,
  MdCoreModule,
  MdDatepickerModule,
  MdDialogModule,
  MdExpansionModule,
  MdGridListModule,
  MdIconModule,
  MdIconRegistry,
  MdInputModule,
  MdListModule,
  MdMenuModule,
  MdNativeDateModule,
  MdPaginatorModule,
  MdProgressBarModule,
  MdProgressSpinnerModule,
  MdRadioModule,
  MdRippleModule,
  MdSelectModule,
  MdSidenavModule,
  MdSliderModule,
  MdSlideToggleModule,
  MdSnackBarModule,
  MdSortModule,
  MdTableModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule,
  MaterialModule
} from '@angular/material';
import {CdkTableModule} from '@angular/cdk';

// Browser Animation 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//flex layout
import { FlexLayoutModule } from '@angular/flex-layout';

// different theme
//import 'style-loader!@angular/material/prebuilt-themes/pink-bluegrey.css';
// import 'style-loader!@angular/material/prebuilt-themes/deeppurple-amber.css';
import 'style-loader!@angular/material/prebuilt-themes/indigo-pink.css';
// import 'style-loader!@angular/material/prebuilt-themes/purple-green.css';


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
    BrowserModule,
    MaterialModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    AppRoutingModule,
    HttpModule,
    CdkTableModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    GuestGuard,
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
