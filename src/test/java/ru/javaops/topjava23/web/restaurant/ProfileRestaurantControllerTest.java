package ru.javaops.topjava23.web.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.javaops.topjava23.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javaops.topjava23.web.restaurant.RestaurantTestHelper.*;
import static ru.javaops.topjava23.web.user.UserTestHelper.USER_MAIL;

class ProfileRestaurantControllerTest extends AbstractControllerTest {

    private static final String REST_URL = ProfileRestaurantController.REST_URL + "/";
    private static final String OLD_DATE_PARAM = "2021-09-01";

    @Test
    @WithUserDetails(value = USER_MAIL)
    void getAllRestaurantsWithTodaysMenu() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(WITH_DISHES_MATCHER.contentJson(restaurant1, restaurant2, restaurant3));
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void getAllRestaurantsWithMenuByDate() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + "by?date=" + OLD_DATE_PARAM))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentJson(restaurant2, restaurant1));
    }
}