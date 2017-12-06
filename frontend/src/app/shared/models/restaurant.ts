import { Address } from './address';
import { Category } from './category';
export class Restaurant {
    categoryNames : string;
    constructor(public id: number,
      public restaurantName: String,
      public description: String,
      public phone: String,
      public address: Address,
      public category: Category[]) {
        this.categoryNames = this.category.map(c => c.categoryName).join(',');
    };
}