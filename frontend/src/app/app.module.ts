import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpModule } from '@angular/http';
// material
import { MaterialModule, MdIconRegistry } from '@angular/material';

//flex layout
import { FlexLayoutModule } from '@angular/flex-layout';

// different theme
//import 'style-loader!@angular/material/prebuilt-themes/pink-bluegrey.css';
// import 'style-loader!@angular/material/prebuilt-themes/deeppurple-amber.css';
import 'style-loader!@angular/material/prebuilt-themes/indigo-pink.css';
// import 'style-loader!@angular/material/prebuilt-themes/purple-green.css';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurant/restaurant-detail/restaurant-detail.component';

// import service
import { RestaurantService } from './restaurant/restaurant.service';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    RestaurantComponent,
    RestaurantDetailComponent 
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    FlexLayoutModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [RestaurantService],
  bootstrap: [AppComponent]
})
export class AppModule { }
