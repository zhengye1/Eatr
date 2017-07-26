import { Address } from './address';
import { Category } from '../category';

export class Restaurant {
  constructor(public id: number,
              public restaurant_name: string,
              public description: string,
              public phone: String,
              public address: Address,
              public category: Category[]) {
  }
}
