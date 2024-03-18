package tuan_1_api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private long id;
    private String name;
}
