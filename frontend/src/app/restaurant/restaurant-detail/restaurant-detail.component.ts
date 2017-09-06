import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../restaurant';
import { RestaurantService } from '../restaurant.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css']
})
export class RestaurantDetailComponent implements OnInit {
  id: Number;
  sub: any;
  restaurant: Restaurant;
  constructor(private restaurantService: RestaurantService, private route: ActivatedRoute) { }

  async ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });
    await this.restaurantService.getRestaurant(this.id);
    console.log(this.restaurant);
  }

}
