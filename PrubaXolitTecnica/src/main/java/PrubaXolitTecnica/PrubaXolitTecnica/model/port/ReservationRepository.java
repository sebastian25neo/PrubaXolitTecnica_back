package PrubaXolitTecnica.PrubaXolitTecnica.model.port;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Reservation;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();
    void deleteById(Long id);

    Optional<Reservation> findByResourceIdAndStartTimeAndEndTime(Long resourceId, LocalDateTime startTime, LocalDateTime endTime);

    List<Reservation> findByUserIdAndStartTimeBetween(Long userId, LocalDateTime startOfDay, LocalDateTime endOfDay);

    List<Reservation> findOverlappingReservations(Long resourceId, LocalDateTime startTime, LocalDateTime endTime);

}