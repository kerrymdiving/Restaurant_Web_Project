package co.uk.barclays.httpserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface MenuRepository extends JpaRepository<Menu, Integer> {}
