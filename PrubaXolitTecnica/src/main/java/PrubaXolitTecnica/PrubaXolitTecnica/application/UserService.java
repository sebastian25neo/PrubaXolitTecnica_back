package PrubaXolitTecnica.PrubaXolitTecnica.application;

import PrubaXolitTecnica.PrubaXolitTecnica.model.User;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Lógica adicional, como validaciones o transformación de datos antes de guardar
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
