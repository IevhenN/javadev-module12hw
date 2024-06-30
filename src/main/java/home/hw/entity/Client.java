package home.hw.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
}
