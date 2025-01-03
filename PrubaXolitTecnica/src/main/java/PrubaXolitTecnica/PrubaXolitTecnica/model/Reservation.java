package PrubaXolitTecnica.PrubaXolitTecnica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String userName;  // New field
    private Long resourceId;
    private String resourceName;  // New field
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}