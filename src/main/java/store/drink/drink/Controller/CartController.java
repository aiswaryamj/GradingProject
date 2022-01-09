package store.drink.drink.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import store.drink.drink.Model.Address;
import store.drink.drink.Model.OrderItem;
import store.drink.drink.Repository.AddressRepository;
import store.drink.drink.Repository.OrderItemRepository;

import javax.validation.Valid;

@Controller
//@RequestMapping(value = "/Cart")
public class CartController {
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;

    public CartController(OrderItemRepository orderItemRepository, AddressRepository addressRepository) {
        this.orderItemRepository = orderItemRepository;
        this.addressRepository = addressRepository;
    }


    @GetMapping("/Cart")
    public String getOrderItems(Model model) {
        model.addAttribute("OrderItems", orderItemRepository.findAll());
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

    @PostMapping("/Cart")
    public String addDrinksToCart(@Valid @RequestBody Address address, Errors errors, Model model) {
        if (errors.hasErrors()) {

            model.addAttribute("address", this.addressRepository.save(address));
            return "Cart";
        }
        this.addressRepository.save(address);
        return "redirect:/Orders";
    }

//    @PostMapping
//    public String postItem(@RequestBody Address address,Model model) {
//        addressRepository.save(address);
//        return "redirect:/Cart";
//    }
}
