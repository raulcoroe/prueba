package raulmartin.prueba.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bike")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int code;
    @Column
    private boolean availability;
    @Column
    private int station;

    @OneToMany(mappedBy = "bike", cascade = CascadeType.REMOVE)
    @JsonBackReference(value = "rent_bike")
    List<Rent> rents;
}
