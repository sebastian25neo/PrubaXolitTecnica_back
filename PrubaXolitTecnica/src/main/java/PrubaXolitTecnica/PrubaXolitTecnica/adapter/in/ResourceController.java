package PrubaXolitTecnica.PrubaXolitTecnica.adapter.in;

import PrubaXolitTecnica.PrubaXolitTecnica.application.ResourceService;
import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<Object> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);

        // Creando un mensaje de éxito en formato JSON
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Recurso creado con éxito");
        response.put("resourceId", createdResource.getId());
        response.put("status", "éxito");

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResource(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>("Resource deleted successfully", HttpStatus.NO_CONTENT);
    }
}
