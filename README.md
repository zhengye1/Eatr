# Eatr
A full stack app to show the reviews of restaurants

# Technology
Angular 2, TypeScript, Spring Boot, Hibernate, MySQL

# Requirements:
1. A visitor to the main page of the site, “Alice,”  the site should able to provide the list of open restaurant near the user's current location

2. Alice should be able search for restaurants that matching some combination of:
 - The name of the restaurant or a part of a name (e.g., “Maroli”).
 - Tags describing cuisine type / regional origin (e.g., “Uighur”, “Andhra”, “Russian”, “Indian”). Note that the same restaurant could be at the same time “Andhra”, “Indian”, and “Vegetarian”.
 - The search should result in a list of restaurants with a name of each restaurant and its average rating.

3. Alice should be able to click on a restaurant from the list and see the following information about it:
  - The name of the restaurant.
  - Associated tags (see above).
  - The address and phone number.
  - Price range (from “$” to “$$$$$”).
  - A list of comments from visitors, which would include a rating, from one to five stars.
  - The average of visitor ratings.
  - A list of available dishes.
  - Open Hours
  - Map of the location
  
4. Alice should able to provide the rating and comments, the range for rating should be from 1 to 5, and based on 
  - Service_Rating, Food_Rating, Value_Rating, Price
  
5.  When looking at a comment by “Bob”, Alice should be able to click on Bob's name to see Bob's profile
and the list of all Bob's comments. The list of Bob's comments show which restaurant each comment refers to.

6. Alice should be able to mark Bob's comment as “helpful” or “unhelpful.” When applicable, comments 
would be shown with a note saying something like “24 out of 32 people found this helpful.”

7. If admin is logging to the site, he/she will able to perform CRUD operations on restaurants data and users' comments.
