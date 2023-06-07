package backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "materials")
@Data
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String category;

    @Column
    private String name;

    @Column
    private int amount;
}