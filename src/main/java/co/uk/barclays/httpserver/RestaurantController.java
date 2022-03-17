package co.uk.barclays.httpserver;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    private RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/restaurants") // Read All
    public List<Restaurant> getRestaurants() {
        return this.repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getOneRestaurant(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant newRestaurant) {
        return repository.save(newRestaurant);
    }

    @PutMapping("/restaurants/{id}")
    public Restaurant updateOneRestaurant(@PathVariable Integer id, @RequestBody Restaurant restaurantUpdate) {
        return repository.findById(id)
            .map(restaurant -> {
                restaurant.setName(restaurantUpdate.getName());
                restaurant.setImageURL(restaurantUpdate.getImageURL());
                return repository.save(restaurant);
            }).orElseThrow();
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteOneRestaurant(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
