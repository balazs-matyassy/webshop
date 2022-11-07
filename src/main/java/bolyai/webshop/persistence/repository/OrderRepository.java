package bolyai.webshop.persistence.repository;

import bolyai.webshop.persistence.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
