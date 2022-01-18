package store.drink.drink.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import store.drink.drink.Model.Address;
import store.drink.drink.Model.Orders;
import store.drink.drink.Repository.AddressRepository;
import store.drink.drink.Repository.OrderItemRepository;
import store.drink.drink.Repository.OrderRepository;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/Cart")
public class CartController {
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;

    public CartController(OrderItemRepository orderItemRepository, AddressRepository addressRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getOrderItems(Model model) {
        model.addAttribute("OrderItems", orderItemRepository.findAll());
        model.addAttribute("addAddress", addressRepository.findAll());
        model.addAttribute("address", new Address());
//        model.addAttribute("totalPrice", orderItemRepository.getTotalPrice());
        return "Cart";
    }

    @PostMapping
    public String deleteOrderItemsAndCreateNewOrder(@Valid Address address, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("addAddress", addressRepository.findAll());
            return "Cart";
        }
        addressRepository.save(address);
        Orders order = new Orders();
        order.setPrice("50");
        orderRepository.save(order);
        orderItemRepository.deleteAll();
        return "Cart";
    }

    @GetMapping("delete/{id}")
    public String deleteAnItem(@PathVariable Long id) {
        orderItemRepository.deleteById(id);
        return "Cart";
    }

}
