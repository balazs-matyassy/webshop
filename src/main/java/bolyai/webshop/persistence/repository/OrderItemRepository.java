package bolyai.webshop.persistence.repository;

import bolyai.webshop.persistence.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
