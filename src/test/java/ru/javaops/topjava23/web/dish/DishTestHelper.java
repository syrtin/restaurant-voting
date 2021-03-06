package ru.javaops.topjava23.web.dish;

import ru.javaops.topjava23.model.Dish;
import ru.javaops.topjava23.web.MatcherFactory;

import java.time.LocalDate;
import java.util.List;

import static ru.javaops.topjava23.web.restaurant.RestaurantTestHelper.*;

public class DishTestHelper {
    public static final MatcherFactory.Matcher<Dish> MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator(Dish.class, "restaurant");

    public static final int DISH1_ID = 1;
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate OLD_DATE = LocalDate.of(2021, 9, 1);

    public static final Dish dish1 = new Dish(DISH1_ID, "Big Tasty", CURRENT_DATE, 249, restaurant1);
    public static final Dish dish2 = new Dish(DISH1_ID + 1, "Nuggets", CURRENT_DATE, 69, restaurant1);
    public static final Dish dish3 = new Dish(DISH1_ID + 2, "Sprite M", CURRENT_DATE, 75, restaurant1);
    public static final Dish dish4 = new Dish(DISH1_ID + 3, "Boxmaster", CURRENT_DATE, 199, restaurant2);
    public static final Dish dish5 = new Dish(DISH1_ID + 4, "6 Stripes", CURRENT_DATE, 214, restaurant2);
    public static final Dish dish6 = new Dish(DISH1_ID + 5, "Pepsi M", CURRENT_DATE, 79, restaurant2);
    public static final Dish dish7 = new Dish(DISH1_ID + 6, "Whopper", CURRENT_DATE, 189, restaurant3);
    public static final Dish dish8 = new Dish(DISH1_ID + 7, "9 Onion Rings", CURRENT_DATE, 129, restaurant3);
    public static final Dish dish9 = new Dish(DISH1_ID + 8, "Diet Coke M", CURRENT_DATE, 119, restaurant3);
    public static final Dish dish10 = new Dish(DISH1_ID + 9, "BigMac", OLD_DATE, 301, restaurant1);
    public static final Dish dish11 = new Dish(DISH1_ID + 10, "Fries", OLD_DATE, 201, restaurant1);
    public static final Dish dish12 = new Dish(DISH1_ID + 11, "Cola", OLD_DATE, 101, restaurant1);
    public static final Dish dish13 = new Dish(DISH1_ID + 12, "Twister", OLD_DATE, 302, restaurant2);
    public static final Dish dish14 = new Dish(DISH1_ID + 13, "Fries", OLD_DATE, 202, restaurant2);
    public static final Dish dish15 = new Dish(DISH1_ID + 14, "Cola", OLD_DATE, 102, restaurant2);

    public static final List<Dish> restaurant1CurrentDate = List.of(dish1, dish2, dish3);
    public static final List<Dish> restaurant2CurrentDate = List.of(dish4, dish5, dish6);
    public static final List<Dish> restaurant3CurrentDate = List.of(dish7, dish8, dish9);

    public static Dish getNew() {
        return new Dish(null, "New", CURRENT_DATE, 300, restaurant1);
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "UpdatedName", CURRENT_DATE, 200, restaurant1);
    }
}