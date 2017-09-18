import { Component, OnInit, Input } from '@angular/core';
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
  @Input() restaurant: Restaurant;
  constructor(private restaurantService: RestaurantService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id']; // (+) converts string 'id' to a number
    });
    this.restaurantService.getRestaurant(this.id).then(
      res => this.restaurant = new Restaurant(res.id, res.restaurant_name, res.description
      , res.phone, res.address, res.category));
  }

}
