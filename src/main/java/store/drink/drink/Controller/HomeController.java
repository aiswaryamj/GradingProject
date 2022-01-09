package store.drink.drink.Controller;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.drink.drink.Model.Bottle;
import store.drink.drink.Model.Crate;
import store.drink.drink.Model.OrderItem;
import store.drink.drink.Repository.BottleRepository;
import store.drink.drink.Repository.CrateRepository;
import store.drink.drink.Repository.OrderItemRepository;

import javax.validation.Valid;

@Slf4j
@Controller
//@RequestMapping(value = "/Home")
public class HomeController {



//    private final DrinksService drinksService;
//
//    @Autowired
//    public HomeController(DrinksService drinksService){
//        this.drinksService=drinksService;
//    }

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

//    @PostMapping(value="/Home/crate")
//    public String addCrate(Model model, Crate crate) {
//            OrderItem orderItem = new OrderItem(1L, 1, crate.getPrice(), crate.getName(), 1);
//            model.addAttribute("crate", orderItemRepository.save(orderItem));
//            model.addAttribute("added", true);
//            return "Home";
//    }


//    @RequestMapping("/Home")
//    private String getCrates(Model model){
//        model.addAttribute("crates", crateRepository.findAll());
//        return "Home";
//    }

//    @GetMapping
//    public String getBottles(Model model) {
//
//        log.info("Function to display all bottles");
//        //model.addAttribute("AddBeverage", this.bottles);
//
//        model.addAttribute("Home", this.bottleRepository.findAll());
//        //model.addAttribute("bottles", new Bottle());
//        return "Home";
//
//    }

//    @GetMapping
//    public ModelAndView getBottles()
//    {
//        ModelAndView mav = new ModelAndView("Home");
//        mav.addObject("bottles", bottleRepository.findAll());
//        return mav;
//    }
//
//    @GetMapping
//    public ModelAndView getCrates()
//    {
//        ModelAndView mav = new ModelAndView("Home");
//        mav.addObject("crates", drinksService.getCrates());
//        return mav;
//    }
}
