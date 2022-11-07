package bolyai.webshop.init;

import bolyai.webshop.persistence.model.Order;
import bolyai.webshop.persistence.model.OrderItem;
import bolyai.webshop.persistence.repository.OrderItemRepository;
import bolyai.webshop.persistence.repository.OrderRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitDBRunner implements ApplicationRunner {
    private final OrderRepository orderRepository;

    private final OrderItemRepository itemRepository;

    public InitDBRunner(OrderRepository orderRepository, OrderItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Order order = new Order(LocalDateTime.now(), "Első ember");
        orderRepository.save(order);

        OrderItem item = new OrderItem(order, "Termék 1", 5, 2000);
        itemRepository.save(item);
        item = new OrderItem(order, "Termék 2", 1, 1000);
        itemRepository.save(item);
        item = new OrderItem(order, "Termék 3", 2, 5000);
        itemRepository.save(item);

        order = new Order(LocalDateTime.now().minusDays(2), "Második ember");
        orderRepository.save(order);

        item = new OrderItem(order, "Termék 1", 1, 2000);
        itemRepository.save(item);
        item = new OrderItem(order, "Termék 3", 1, 5000);
        itemRepository.save(item);

        order = new Order(LocalDateTime.now().minusDays(7), "Chuck Norris");
        orderRepository.save(order);

        item = new OrderItem(order, "Kalap", 1, 200000);
        itemRepository.save(item);
    }
}
