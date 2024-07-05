package home.hw.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @Column(name = "client_id", nullable = false)
    long clientId;
    @Column(name = "from_planet_id", nullable = false, length = 10)
    String fromPlanetId;
    @Column(name = "to_planet_id", nullable = false, length = 10)
    String toPlanetId;
}
