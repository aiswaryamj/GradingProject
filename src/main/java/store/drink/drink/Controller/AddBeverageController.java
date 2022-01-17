package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.drink.drink.Model.Bottle;
import store.drink.drink.Model.Crate;
import store.drink.drink.Repository.BottleRepository;
import store.drink.drink.Repository.CrateRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/AddBeverage")
public class AddBeverageController {

    private final BottleRepository bottleRepository;
    private final CrateRepository crateRepository;

    @Autowired
    public AddBeverageController(BottleRepository bottleRepository, CrateRepository crateRepository) {
        this.bottleRepository = bottleRepository;
        this.crateRepository = crateRepository;
    }

//     private List<bottle> bottles;
//
//    public AddItem(List<bottle> bottles, BottleRepository bottleRepository) {
//        this.bottleRepository = bottleRepository;
//        this.bottles = new ArrayList<>();
//        this.bottles.add(new bottle("1", "cola", "picture", 1, true, 40, 13, "pepsi cola", 30));
//
//    }

    @PostMapping
    public String addDrinksToCart(@Valid Bottle bottle, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("AddBeverage", this.bottleRepository.findAll());
            return "AddBeverage";
        }
        this.bottleRepository.save(bottle);
        return "redirect:/Home";
    }

//    @PostMapping
//    public String postItem(@Valid Bottle bottle, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            //model.addAttribute("AddBeverage", this.bottles);
//            model.addAttribute("AddBeverage", this.bottleRepository.findAll());
//            return "/AddBeverage";
//        }
////        bottle.setId("m" + (this.bottleRepository.count() + 1));
//        // bottle.setId("" + (this.bottles.size() + 1));
//        //  this.bottles.add(bottle);
//        this.bottleRepository.save(bottle);
//        return "redirect:/Home";
//    }

    @GetMapping
    public String getItem(Model model) {
        model.addAttribute("AddBeverage", this.bottleRepository.findAll());
        model.addAttribute("AddBeverage",this.crateRepository.findAll());
        model.addAttribute("bottle", new Bottle());
        model.addAttribute("crate",new Crate());
        return "/AddBeverage";

    }
//
//    @PostMapping
//    public String postItem(@Valid Bottle bottle, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("AddBeverage", this.bottles);
////            model.addAttribute("AddBeverage", this.bottleRepository.findAll());
//            return "AddBeverage";
//        }
////        bottle.setId("m" + (this.bottleRepository.count() + 1));
//        // bottle.setId("" + (this.bottles.size() + 1));
//        //  this.bottles.add(bottle);
//        this.bottleRepository.save(bottle);
//        return "redirect:/Home";
//    }

}
