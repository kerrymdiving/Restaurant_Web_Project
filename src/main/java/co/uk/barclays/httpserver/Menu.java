package co.uk.barclays.httpserver;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String menu_title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    @JsonManagedReference
    private List<Items> items;

    @ManyToOne
    @JsonBackReference
    private Restaurant restaurant;
    
    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenu_title() {
        return this.menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }


}
