import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    RestaurantComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
