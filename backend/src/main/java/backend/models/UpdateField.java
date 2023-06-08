package backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UpdateField {
    @Column
    private String value;
}
