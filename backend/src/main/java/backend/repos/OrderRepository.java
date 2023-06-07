package backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByInstrument(String instrument);
}