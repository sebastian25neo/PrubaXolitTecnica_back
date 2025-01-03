package PrubaXolitTecnica.PrubaXolitTecnica.adapter.out;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceJpaRepository extends JpaRepository<Resource, Long> {
}