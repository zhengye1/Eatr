import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { RestaurantComponent } from './restaurant/restaurant.component';
import { RestaurantDetailComponent } from './restaurant/restaurant-detail/restaurant-detail.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { GuestGuard } from './guard/guest.guard';
import { AdminGuard } from './guard/admin.guard';
const routes: Routes = [
   { path:'', component: HomeComponent},
   { path: 'restaurant/:id', component: RestaurantDetailComponent },
   { path: 'restaurant',  component: RestaurantComponent },
   { path: 'admin', component: AdminComponent, canActivate:[AdminGuard]},
   { path: 'login', component: LoginComponent, canActivate: [GuestGuard]}
];
 
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}