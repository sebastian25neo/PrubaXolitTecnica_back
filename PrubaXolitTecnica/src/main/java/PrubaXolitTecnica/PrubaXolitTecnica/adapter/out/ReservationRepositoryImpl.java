package PrubaXolitTecnica.PrubaXolitTecnica.adapter.out;

import PrubaXolitTecnica.PrubaXolitTecnica.model.Reservation;
import PrubaXolitTecnica.PrubaXolitTecnica.model.port.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    private final ReservationJpaRepository jpaRepository;

    public ReservationRepositoryImpl(ReservationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return jpaRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Reservation> findByResourceIdAndStartTimeAndEndTime(Long resourceId, LocalDateTime startTime, LocalDateTime endTime) {
        return jpaRepository.findByResourceIdAndStartTimeAndEndTime(resourceId, startTime, endTime);
    }

    @Override
    public List<Reservation> findByUserIdAndStartTimeBetween(Long userId, LocalDateTime startOfDay, LocalDateTime endOfDay) {
        return jpaRepository.findByUserIdAndStartTimeBetween(userId, startOfDay, endOfDay);
    }

    @Override
    public List<Reservation> findOverlappingReservations(Long resourceId, LocalDateTime startTime, LocalDateTime endTime) {
        return jpaRepository.findOverlappingReservations(resourceId, startTime, endTime);
    }
}
