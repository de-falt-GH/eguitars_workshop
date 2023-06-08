package backend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import backend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByInstrument(String instrument);

    @Query(value = "SELECT id FROM orders WHERE client_id = ?1", nativeQuery = true)
    List<Integer> findAllOrderIdsByUserId(long client_id);
}