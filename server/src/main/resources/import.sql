insert into city(City_Name) values ('Scarborough'), ('Toronto'), ('Markham'), ('Mississauga'), ('Richmond Hill'), ('North York');
insert into address (address, city_id, postal_code, latitude, longitude) values ('2803 Eglinton Ave E', 1, 'M1J 2E1', 43.737245, -79.244367);
insert into address (address, city_id, postal_code, latitude, longitude) values ('7010 Warden Ave', 3, 'L3R 5Y3', 43.85939, -79.304654);
insert into address (address, city_id, postal_code, latitude, longitude) values ('332 Spadina Ave', 2, 'M5T 2G2', 43.65406, -79.398905);

insert into Restaurant(Restaurant_Name, Description, Address_ID, Phone_Number) values ('Nakamori', 'Japanese Restaurant', 1, '416-265-7111');
insert into Restaurant(Restaurant_Name, Description, Address_ID, Phone_Number) values ('Ajisen Ramen Markham', 'Japanese Restaurant', 2, '905-604-8299');
insert into Restaurant(Restaurant_Name, Description, Address_ID, Phone_Number) values ('Ajisen Ramen Toronto', 'Japanese Restaurant', 3, '416-977-8080');

insert into Category(Category_Name) values ('Asian'), ('Japanese');
insert into Restaurant_Category (Restaurant_ID, Category_ID) values (1,1), (2, 1), (3,1), (2, 2), (3, 2);
--
--insert into Category(Category_Name)
--values 
--('Japanese'),
--('Sushi Bars');
--
--insert into restaurant_category(restaurant_id, category_id)
--values
--(1,1),
--(1,2);
--
--insert into Business_Hour(Restaurant_ID, Day, Open_Time, Close_Time)
--values
--(1, 2, TIME('11:30'), TIME('14:00'))
--(1, 3, TIME('11:30'), TIME('14:00')),
--(1, 4, TIME('11:30'), TIME('14:00')),
--(1, 5, TIME('11:30'), TIME('14:00')),
--(1, 2, TIME('17:30'), TIME('21:30')),
--(1, 3, TIME('17:30'), TIME('21:30')),
--(1, 4, TIME('17:30'), TIME('21:30')),
--(1, 5, TIME('17:30'), TIME('21:30')),
--(1, 6, TIME('17:30'), TIME('21:30'))
