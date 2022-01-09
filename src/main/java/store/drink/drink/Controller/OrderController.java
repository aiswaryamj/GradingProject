package store.drink.drink.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Model.Orders;

import java.util.List;

@Controller
@RequestMapping(value = "/Orders")

public class OrderController {
//    private final List<Orders> orders;

//    public OrderController(List<Orders> orders) {
//        this.orders = orders;
//        this.orders.add(new Orders());
//    }
//
//    @GetMapping
//    public String getOrders(Model model) {
//        //Model is from spring ui, used by backend developers as servelets
//        model.addAttribute("Orders", this.orders);
//        return "Orders";
//
//    }
}
