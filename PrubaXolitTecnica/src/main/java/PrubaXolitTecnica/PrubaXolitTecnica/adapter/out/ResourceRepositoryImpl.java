package PrubaXolitTecnica.PrubaXolitTecnica.adapter.out;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.ResourceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {
    private final ResourceJpaRepository jpaRepository;

    public ResourceRepositoryImpl(ResourceJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Resource save(Resource resource) {
        return jpaRepository.save(resource);
    }

    @Override
    public Optional<Resource> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Resource> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}