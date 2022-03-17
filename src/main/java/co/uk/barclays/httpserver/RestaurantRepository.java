package co.uk.barclays.httpserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {}
