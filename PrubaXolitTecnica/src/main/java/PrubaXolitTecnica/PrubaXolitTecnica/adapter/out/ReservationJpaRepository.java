package PrubaXolitTecnica.PrubaXolitTecnica.adapter.out;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByResourceIdAndStartTimeAndEndTime(Long resourceId, LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT r FROM Reservation r WHERE r.userId = :userId AND r.startTime BETWEEN :startOfDay AND :endOfDay")
    List<Reservation> findByUserIdAndStartTimeBetween(
            @Param("userId") Long userId,
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay
    );

    @Query("SELECT r FROM Reservation r WHERE r.resourceId = :resourceId AND " +
            "(:startTime < r.endTime AND :endTime > r.startTime)")
    List<Reservation> findOverlappingReservations(
            @Param("resourceId") Long resourceId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
