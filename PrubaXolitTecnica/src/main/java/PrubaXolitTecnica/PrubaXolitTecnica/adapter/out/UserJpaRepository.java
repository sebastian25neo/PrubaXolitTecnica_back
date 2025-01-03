package PrubaXolitTecnica.PrubaXolitTecnica.adapter.out;

import PrubaXolitTecnica.PrubaXolitTecnica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
