package co.uk.barclays.httpserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    private MenuRepository repository;
    private RestaurantRepository restaurantRepository;

    public MenuController(MenuRepository repository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
    }

    @PostMapping("/restaurants/{restaurant_id}/menus")
    public Menu newMenu(@RequestBody Menu newMenu, @PathVariable Integer restaurant_id) {
        Restaurant restaurant = restaurantRepository.findById(restaurant_id).get();
        newMenu.setRestaurant(restaurant);
        return repository.save(newMenu);
    }

}
