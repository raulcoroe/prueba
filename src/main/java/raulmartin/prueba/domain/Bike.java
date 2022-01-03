package raulmartin.prueba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    @Column
    private int id;
    @Column
    private int code;
    @Column
    private boolean availability;
    @Column
    private int station;
}
