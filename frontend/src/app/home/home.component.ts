import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../shared/models/restaurant';
import { Observable } from 'rxjs/Observable';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';

import {
  FooService,
  ConfigService,
  UserService,
  RestaurantService
} from '../service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  fooResponse = {};
  whoamIResponse = {};
  allUserResponse = {};
  displayedColumns = ['Id', 'Name', 'Category', 'Address', 'City'];
  //displayedColumns = ['Name', 'Category'];
  exampleDatabase: ExampleHttpDao | null;
  dataSource = new MatTableDataSource();
  constructor(
    private config: ConfigService,
    private fooService: FooService,
    private userService: UserService,
    private restaurantService: RestaurantService
  ) { }

  ngOnInit() {
    this.exampleDatabase = new ExampleHttpDao(this.restaurantService);
    Observable.fromPromise(this.exampleDatabase.getCurrentLocation())
    .subscribe(data => this.dataSource.data = data);
  }

}

export class ExampleHttpDao {
  private lat;
  private lon;
  restaurants;
  constructor(private restaurantService: RestaurantService) {

  }

  getPosition = () => {
    var latitude, longitude;
    return new Promise((resolve, reject) => {
      navigator.geolocation.getCurrentPosition((position) => {
        resolve(position.coords);
      }, (err) => {
        resolve({ 'latitude': '44.0', 'longitude': '22.0' });
        //reject(err);
      });
    })
  }

  async getCurrentLocation()  {
    let coords = await this.getPosition();
    this.lat = coords['latitude'];
    this.lon = coords['longitude'];
    var result = this.restaurantService.getRestaurantsByLoation(this.lat, this.lon).map(this.extractData);
    return await result.toPromise();
  }

  extractData(result: Response){
    this.restaurants = result;
    for (const res in result){
      var restaurant = result[res];
      this.restaurants[res] = new Restaurant(restaurant.id, restaurant.restaurantName, restaurant.description, 
        restaurant.phone, restaurant.address, restaurant.category);
    }
    return this.restaurants;
  }

  getByCity(city: string) {
    return this.restaurantService.getRestaurantByCity(city).toPromise();
  }
}