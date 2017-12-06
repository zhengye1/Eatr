import { City } from './city';
export class Address {
    constructor(public id: number,
        public address: string,
        public postal_code: string,
        public lat: number,
        public lon: number,
        public city: City) {
    }
}