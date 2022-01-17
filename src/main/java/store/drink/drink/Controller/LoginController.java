package store.drink.drink.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.drink.drink.Model.User;
import store.drink.drink.Repository.UserRepository;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {

private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping
//    public String getUsers(Model model)
//    {
//        return "Login.html";
//    }

    @PostMapping(value = "/Login")
    public String addUser(@RequestBody User user)
    {
//        userRepository.save(user);
        return "Home";
    }

}
