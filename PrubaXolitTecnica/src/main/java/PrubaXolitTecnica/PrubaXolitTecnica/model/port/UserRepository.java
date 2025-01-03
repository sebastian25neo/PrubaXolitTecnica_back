package PrubaXolitTecnica.PrubaXolitTecnica.model.port;

import PrubaXolitTecnica.PrubaXolitTecnica.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user); // Guarda un usuario
    Optional<User> findById(Long id); // Busca un usuario por ID
    List<User> findAll(); // Obtiene todos los usuarios
    void deleteById(Long id); // Elimina un usuario por ID
}
