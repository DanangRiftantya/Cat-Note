package danangriftantya.Cat.Note.user;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user.register")
    @SendTo("/topic/public")
    public User registerUser(String username, String password) {
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return user;
    }

    @GetMapping("/user.login")
    @SendTo("/topic/public")
    public boolean loginUser(String username, String password) {
        User existingUser = userService.findByUsername(username);
        if (existingUser == null) {
            if (passwordEncoder.matches(password, existingUser.getPassword())) {
                return true;
            }
            else {
                throw new RuntimeException("Incorrect password!");
            }
        }
        else {
            throw new RuntimeException("User not found!");
        }
    }

}
