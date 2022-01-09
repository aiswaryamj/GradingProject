package store.drink.drink.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Repository.OrderRepository;

@Controller
@RequestMapping(value = "/Orders")

public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
//    private final List<Orders> orders;

//    public OrderController(List<Orders> orders) {
//        this.orders = orders;
//        this.orders.add(new Orders());
//    }

    @GetMapping
    public String getOrders(Model model) {
        model.addAttribute("Orders", orderRepository.findAll());
        return "Orders";

    }
}
