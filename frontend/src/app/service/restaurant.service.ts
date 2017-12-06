import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { ConfigService } from './config.service';
@Injectable()
export class RestaurantService {

  restaurants;
  constructor(private apiService: ApiService,
    private configService: ConfigService) {

  }

  getRestaurants() {
    return this.apiService.get(this.configService.restaurant_url);
  }

  getRestaurant(id: Number) {
    return this.apiService.get(this.configService.restaurant_url + '/' + id);
  }

  getRestaurantsByLoation(lat: Number, lon: Number) {
    const body = `lat=${lat}&lon=${lon}`;
    return this.apiService.get(this.configService.search_url + '/location', body);
  }

  getRestaurantByCity(city:String){
    const body=`city=${city}`;
    return this.apiService.get(this.configService.search_url, body);
  }
}
