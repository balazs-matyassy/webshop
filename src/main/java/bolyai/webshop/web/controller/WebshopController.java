package bolyai.webshop.web.controller;

import bolyai.webshop.persistence.model.Order;
import bolyai.webshop.persistence.repository.OrderItemRepository;
import bolyai.webshop.persistence.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebshopController {
    private final OrderRepository orderRepository;

    private final OrderItemRepository itemRepository;

    public WebshopController(OrderRepository orderRepository, OrderItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/orders")
    public String listAllOrders(Model model) {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        model.addAttribute("title", "List orders");
        model.addAttribute("orders", orders);

        return "orders";
    }

}
