import { Component, OnInit } from '@angular/core';
import { Http, Response, URLSearchParams } from '@angular/http';
import { DataSource } from '@angular/cdk';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import { Restaurant } from '../restaurant/restaurant';
import { Category } from '../category/category';
import { RestaurantService } from '../restaurant/restaurant.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  displayedColumns = ['Id', 'Name', 'Category', 'Address', 'City'];
  exampleDatabase: ExampleHttpDatabase | null;
  dataSource: ExampleDataSource | null;
  location: CurrentLocation | null;
  constructor(http: Http) {
    this.exampleDatabase = new ExampleHttpDatabase(http);
    this.dataSource = new ExampleDataSource(this.exampleDatabase);
    this.location = new CurrentLocation(http);
  }

  ngOnInit() {
    this.location.getCurrentLocation();
    this.location.test();
    this.dataSource.connect();
  }
}

export class ExampleHttpDatabase {
  private restaurantUrl = 'api/restaurant'; // URL to web API
  getRestaurants(): Observable<Restaurant[]> {
    var result = this.http.get(this.restaurantUrl)
      .map(this.extractData);
    result.toPromise();
    return result;
  }

  extractData(result: Response): Restaurant[] {
    return result.json().map(restaurant => {
      return {
        id: restaurant.id,
        name: restaurant.restaurant_name,
        category: restaurant.category.map(c => c.categoryName).join(','),
        address: restaurant.address.address,
        city: restaurant.address.city.city_name
      }
    });
  }
  constructor(private http: Http) { }
}

export class CurrentLocation {
  constructor(private http: Http) { }
  private lat: any;
  private lon: any;
  private params = new URLSearchParams();
  private url = 'api/search/location';


  getPosition = () => {
    var latitude, longitude;
    return new Promise((resolve, reject) => {
      navigator.geolocation.getCurrentPosition((position) => {
        resolve(position.coords);
      }, (err) => {
        reject(err);
      });
    })
  }
  async getCurrentLocation(): Promise<any> {
    let coords = await this.getPosition();
    this.lat = coords['latitude'];
    this.lon = coords['longitude'];
    this.params.set('lat', this.lat);
    this.params.set('lon', this.lon);
    var result = this.http.get(this.url, { search: this.params });
    return await result.toPromise();
  }

  test(){
    this.getCurrentLocation();
    console.log(this.lat + " " + this.lon);
  }
}
export class ExampleDataSource extends DataSource<Restaurant> {
  constructor(private _exampleDatabase: ExampleHttpDatabase) {
    super();
  }

  /** Connect function called by the table to retrieve one stream containing the data to render. */
  connect(): Observable<any> {
    return this._exampleDatabase.getRestaurants();
  }

  disconnect() { }
}
