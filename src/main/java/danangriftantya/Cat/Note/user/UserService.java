package danangriftantya.Cat.Note.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;

    public List<User> findAll () {
        return userRepo.findAll();
    }

    public User findById(long id) {
        return userRepo.findById(id).get();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username).get();
    }



}
