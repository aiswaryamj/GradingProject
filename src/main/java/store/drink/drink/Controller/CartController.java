package store.drink.drink.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.drink.drink.Model.Orders;
import store.drink.drink.Repository.AddressRepository;
import store.drink.drink.Repository.OrderItemRepository;
import store.drink.drink.Repository.OrderRepository;

@Controller
public class CartController {
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;

    public CartController(OrderItemRepository orderItemRepository, AddressRepository addressRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.addressRepository = addressRepository;
        this.orderRepository = orderRepository;
    }


    @GetMapping("/Cart")
    public String getOrderItems(Model model) {
        model.addAttribute("OrderItems", orderItemRepository.findAll());
//      model.addAttribute("totalPrice",orderItemRepository.getTotalPrice());
        return "Cart";
    }

    @PostMapping("/Cart")
    public String deleteOrderItemsAndCreateNewOrder() {
        Orders order = new Orders();
        order.setPrice("50");
        orderRepository.save(order);
        orderItemRepository.deleteAll();
        return "Cart";
    }

//    @PostMapping
//    public String addAddress(Model model, @RequestParam("street") String street,
//                                  @RequestParam("number") String number, @RequestParam("postalCode") String postalCode) {
//        Address address = new Address();
//        address.setStreet(street);
//        address.setNumber(number);
//        address.setPostalCode(postalCode);
//        model.addAttribute("address",addressRepository.save(address));
////        addressRepository.save(address);
//        return "redirect:/Cart";
//    }

//    @PostMapping("/Cart")
//    public String addAddress(@Valid @RequestBody Address address, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//
//            model.addAttribute("address", this.addressRepository.save(address));
//            return "Cart";
//        }
//        this.addressRepository.save(address);
//        return "redirect:/Orders";
//    }

}
