import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurant/restaurant-detail/restaurant-detail.component';


const routes: Routes = [
   { path:'', component: HomeComponent},
   { path: 'restaurant/:id', component: RestaurantDetailComponent },
   { path: 'restaurant',  component: RestaurantComponent },
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}