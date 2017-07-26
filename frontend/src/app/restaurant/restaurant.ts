import { Address } from './address';
import { Category } from '../category';

export class Restaurant {
 categoryNames : String;
  constructor(public id: number,
    public restaurant_name: String,
    public description: String,
    public phone: String,
    public address: Address,
    public category: Category[]) {
      this.categoryNames = this.category.map(c => c.categoryName).join(',');
  };
}
