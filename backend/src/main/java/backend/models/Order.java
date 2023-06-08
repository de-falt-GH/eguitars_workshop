package backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int client_id;

    @Column
    private String instrument;

    @Column
    private String status;

    @Column
    private String creationDate;

    @Column
    private String description;
}
