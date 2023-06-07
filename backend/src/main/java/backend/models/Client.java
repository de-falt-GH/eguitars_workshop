package backend.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "clients")
    private List<Order> orders;
}
