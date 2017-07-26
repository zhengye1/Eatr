import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';
 
import 'rxjs/add/operator/toPromise';

import { Restaurant } from './restaurant';
@Injectable()
export class RestaurantService {
  private restaurantUrl = 'api/restaurant'; // URL to web API
  constructor( private http: Http) { }

  //Get all restaurants
  getRestaurants(): Promise<Restaurant[]>{
    return this.http.get(this.restaurantUrl)
    .toPromise()
    .then(response => response.json() as Restaurant[])
    .catch(this.handleError);
  }

  private handleError(error: any) : Promise<any>{
    console.error('Error', error);
    return Promise.reject(error.message || error);
  }
}
