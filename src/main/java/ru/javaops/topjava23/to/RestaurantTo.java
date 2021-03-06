package ru.javaops.topjava23.to;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import ru.javaops.topjava23.HasId;
import ru.javaops.topjava23.model.Dish;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RestaurantTo extends NamedTo implements HasId, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    List<Dish> dishes;
    Integer votesCount;

    public RestaurantTo(Integer id, String name, List<Dish> dishes, Integer votesCount) {
        super(id, name);
        this.dishes = dishes;
        this.votesCount = votesCount;
    }
}