import { Component, OnInit } from '@angular/core';
import { Http, Response, URLSearchParams } from '@angular/http';
import { DataSource } from '@angular/cdk';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/fromPromise';
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
  dataSource: ExampleDataSource | null;
  lat : Number;
  lng : Number;
  constructor(http: Http) {
    //this.exampleDatabase = new ExampleHttpDatabase(http, this.location);
    this.dataSource = new ExampleDataSource(http);

  }

  async ngOnInit() {   
    //await this.dataSource.setLatLon(this.lat, this.lng);
    await this.dataSource.connect();
  }

  
}

export class ExampleDataSource extends DataSource<Restaurant> {
  private url = 'api/search/location';
  private params = new URLSearchParams();
  private lat;
  private lon;
  constructor(private http: Http) {
    super();
  }

  // setLatLon(lat: Number, lng: Number){
  //   console.log(lat, lng);
  // }

  /** Connect function called by the table to retrieve one stream containing the data to render. */
  connect(): Observable<Restaurant[]> {
    // var location;
    // if (navigator.geolocation){
    //   var options = {timeout: 60000};
    //   location = navigator.geolocation.getCurrentPosition((position)=>{
    //     return position;
    //   },(err) =>{
    //     console.log("Error")
    //   }, options);
    // }
    // console.log("Locations: " + location);
    var result = this.getCurrentLocation().then((res) => 
    {
      return res;
    });
    return Observable.fromPromise(result);
  }


  disconnect() { }
  getPosition = () => {
    var latitude, longitude;
    return new Promise((resolve, reject) => {
      navigator.geolocation.getCurrentPosition((position) => {
        resolve(position.coords);
      }, (err) => {
        resolve({'latitude': '44.0', 'longitude': '22.0'});
        //reject(err);
      });
    })
  }
  async getCurrentLocation(): Promise<Restaurant[]> {
    let coords = await this.getPosition();
    this.lat = coords['latitude'];
    this.lon = coords['longitude'];
    this.params.set('lat', this.lat);
    this.params.set('lon', this.lon);
    var result = this.http.get(this.url, { search: this.params }).map(this.extractData);
    return await result.toPromise();
  }
  extractData(result: Response): Restaurant[] {
    return result.json().map(restaurant => {
      return {
        id: restaurant.id,
        name: restaurant.restaurant_name,
        category: restaurant.category.map(c => c.categoryName).join(','),
        address: restaurant.address.address,
        city: restaurant.address.city.cityName
      }
    });
  }
}
