import { Component, OnInit } from '@angular/core';

import { Restaurant } from './restaurant';
import { RestaurantService } from './restaurant.service'
@Component({
  selector: 'app-root',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})

export class RestaurantComponent implements OnInit {
  restaurants: Restaurant[];
  constructor(private restaurantService: RestaurantService) { }

  getRestaurants() {
    return this.restaurantService.getRestaurants()
      .then(restaurants => this.restaurants = restaurants);
  }
  ngOnInit() {
    this.getRestaurants();
  }

}
