package co.uk.barclays.httpserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface ItemsRepository extends JpaRepository<Items, Integer> {
    
}
