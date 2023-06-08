package backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UpdateField {
    @Column
    private String value;
}
