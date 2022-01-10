package store.drink.drink.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.drink.drink.Model.OrderItem;
import store.drink.drink.Repository.BottleRepository;
import store.drink.drink.Repository.CrateRepository;
import store.drink.drink.Repository.OrderItemRepository;


@Slf4j
@Controller
public class HomeController {

    private final OrderItemRepository orderItemRepository;
    private final BottleRepository bottleRepository;
    private final CrateRepository crateRepository;

    @Autowired
    public HomeController(OrderItemRepository orderItemRepository, BottleRepository bottleRepository, CrateRepository crateRepository) {
        this.orderItemRepository = orderItemRepository;
        this.bottleRepository = bottleRepository;
        this.crateRepository = crateRepository;
    }

    @GetMapping("/Home")
    private String getDrinks(Model model){
        model.addAttribute("bottles", bottleRepository.findAll());
        model.addAttribute("crates", crateRepository.findAll());
        return "Home";
    }

    @PostMapping(value="/Home")
    public String addDrinksToCart(Model model, @RequestParam("name") String name,
                             @RequestParam("price") int price) {
        OrderItem orderItem= new OrderItem(1L,"1",0,null,1);
        orderItem.setPrice(price);
        orderItem.setName(name);
        model.addAttribute("bottle | crate", orderItemRepository.save(orderItem));
        model.addAttribute("added", true);
        return "redirect:/Home";
    }

}
