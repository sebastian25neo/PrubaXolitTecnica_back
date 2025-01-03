package PrubaXolitTecnica.PrubaXolitTecnica.application;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Reservation;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        // Validar si el lugar ya está reservado
        boolean placeTaken = reservationRepository.findByResourceIdAndStartTimeAndEndTime(
                reservation.getResourceId(),
                reservation.getStartTime(),
                reservation.getEndTime()
        ).isPresent();

        if (placeTaken) {
            throw new IllegalArgumentException("El lugar ya está reservado para el rango de tiempo seleccionado.");
        }

        // Validar si el usuario ya tiene una reserva activa en el día
        LocalDateTime startOfDay = reservation.getStartTime().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusSeconds(1);

        boolean userHasReservation = !reservationRepository.findByUserIdAndStartTimeBetween(
                reservation.getUserId(),
                startOfDay,
                endOfDay
        ).isEmpty();

        if (userHasReservation) {
            throw new IllegalArgumentException("El usuario ya tiene una reserva activa para este día.");
        }

        // Verificar si hay reservas que se solapen con el rango de tiempo solicitado
        List<Reservation> overlappingReservations = reservationRepository.findOverlappingReservations(
                reservation.getResourceId(),
                reservation.getStartTime(),
                reservation.getEndTime()
        );

        if (!overlappingReservations.isEmpty()) {
            throw new RuntimeException("El recurso ya está reservado en este rango de tiempo.");
        }

        // Si pasa todas las validaciones, se guarda la reserva
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }



    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
