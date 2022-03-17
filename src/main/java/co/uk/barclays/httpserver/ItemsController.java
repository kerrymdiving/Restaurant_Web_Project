package co.uk.barclays.httpserver;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    private ItemsRepository repository;
    private MenuRepository menuRepository;
    
    public ItemsController(ItemsRepository repository, MenuRepository menuRepository) {
        this.repository = repository;
        this.menuRepository = menuRepository;
    }

    @PostMapping("/restaurants/{restaurant_id}/menus/{menu_id}/items")
        public Items items(@RequestBody Items newItems, @PathVariable Integer restaurant_id, @PathVariable Integer menu_id) {
            Menu menu = menuRepository.findById(menu_id).get();
            newItems.setMenu(menu);
            return repository.save(newItems);
        }
}
