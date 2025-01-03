package PrubaXolitTecnica.PrubaXolitTecnica.application;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        // Lógica adicional, como validaciones
        return resourceRepository.save(resource);
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}
