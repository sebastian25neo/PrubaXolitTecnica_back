package PrubaXolitTecnica.PrubaXolitTecnica.adapter.in;

import PrubaXolitTecnica.PrubaXolitTecnica.application.ReservationService;
import PrubaXolitTecnica.PrubaXolitTecnica.model.Reservation;
import PrubaXolitTecnica.PrubaXolitTecnica.model.Resource;
import PrubaXolitTecnica.PrubaXolitTecnica.model.User;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.ResourceRepository;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final UserRepository userRepository;
    private final ResourceRepository resourceRepository;

    // Constructor con inyección de dependencias
    public ReservationController(ReservationService reservationService,
                                 UserRepository userRepository,
                                 ResourceRepository resourceRepository) {
        this.reservationService = reservationService;
        this.userRepository = userRepository;
        this.resourceRepository = resourceRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.createReservation(reservation);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Reserva creada con éxito");
            response.put("reservationId", createdReservation.getId());
            response.put("status", "éxito");

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            errorResponse.put("status", "error");

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();

        List<Map<String, Object>> transformedReservations = reservations.stream().map(reservation -> {
            Map<String, Object> transformedReservation = new HashMap<>();
            transformedReservation.put("id", reservation.getId());
            transformedReservation.put("userId", reservation.getUserId());

            // Consultar el nombre del usuario
            String userName = userRepository.findById(reservation.getUserId())
                    .map(User::getName)
                    .orElse("Unknown User");
            transformedReservation.put("userName", userName);

            transformedReservation.put("resourceId", reservation.getResourceId());

            // Consultar el nombre del recurso
            String resourceName = resourceRepository.findById(reservation.getResourceId())
                    .map(Resource::getName)
                    .orElse("Unknown Resource");
            transformedReservation.put("resourceName", resourceName);

            transformedReservation.put("startTime", reservation.getStartTime());
            transformedReservation.put("endTime", reservation.getEndTime());
            transformedReservation.put("status", reservation.getStatus());

            return transformedReservation;
        }).toList();

        return ResponseEntity.ok(transformedReservations);
    }



    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}