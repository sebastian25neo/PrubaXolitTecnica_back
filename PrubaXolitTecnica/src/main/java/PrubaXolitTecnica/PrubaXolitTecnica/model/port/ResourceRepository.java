package PrubaXolitTecnica.PrubaXolitTecnica.model.port;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository {
    Resource save(Resource resource);
    Optional<Resource> findById(Long id);
    List<Resource> findAll();
    void deleteById(Long id);
}
