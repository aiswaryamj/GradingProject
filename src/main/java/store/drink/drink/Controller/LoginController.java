package store.drink.drink.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.text.Normalizer;
import java.util.List;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {

//    private final DrinksService drinksService;
//
//    @Autowired
//    public LoginController(DrinksService drinksService){
//        this.drinksService=drinksService;
//    }
//
//    @GetMapping
//    public List<User> getUsers()
//    {
//        return drinksService.getUsers();
//    }

//    @GetMapping
//    public User getUserByUsername(String username) throws UserPrincipalNotFoundException {
//        User user = drinksService.findByUsername(username);
//        if (user == null) {
//            throw new UserPrincipalNotFoundException("User not found");
//        }
//        return user;
//    }

//    @PostMapping
//    public void addUser(@RequestBody User user)
//    {
//        drinksService.addUser(user);
////        return books.getBookid();
//    }

//    @RequestMapping
//    public String logincheck(@ModelAttribute ConfigurationPropertyName.Form person) {
//        // TODO Auto-generated method stub
//
//        int value=drinksService.checkLogin("name", "password");
//
//        if(value>0)
//        {
//
//            return "loginsucess";
//
//        }
//        else
//        {
//            return "failure";
//        }
//    }

}
