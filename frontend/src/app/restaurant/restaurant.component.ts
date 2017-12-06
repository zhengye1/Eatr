import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../shared/models/restaurant';
import { RestaurantService } from '../service';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {

  restaurants: Restaurant[];
  constructor(private restaurantService: RestaurantService) { }

  ngOnInit() {
    this.restaurantService.getRestaurants()
      .subscribe(
      res => {
        this.restaurants = res;
        for (var i = 0; i < res.length; i++) {
          var restaurant = res[i];
          this.restaurants[i] = new Restaurant(restaurant.id, restaurant.restaurantName, 
            restaurant.description, restaurant.phone, restaurant.address, restaurant.category);
        }
      })
  }
}
