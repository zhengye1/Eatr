import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurant/restaurant-detail/restaurant-detail.component';


const routes: Routes = [
   { path: '', redirectTo: '/restaurant', pathMatch: 'full' },
   { path: 'restaurant/:id', component: RestaurantDetailComponent },
   { path: 'restaurant',  component: RestaurantComponent },
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}