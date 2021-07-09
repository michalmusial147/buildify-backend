package elc.web;

import elc.data.UserRepository;
import elc.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserBoundary {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public Iterable<AppUser> getAll() {
        Iterable<AppUser> users = userRepository.findAll();
        return userRepository.findAll();
    }


}
