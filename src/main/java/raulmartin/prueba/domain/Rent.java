package raulmartin.prueba.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rent {
    @Column
    private int id;
    @Column(name = "start_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endDate;
    @Column
    private boolean active;
    @Column
    private float cost;

    public float getCost() {
        float COST_PER_MINUTE = (float) 0.10;
        Duration duration = Duration.between(endDate, startDate);
        cost = COST_PER_MINUTE * (duration.getSeconds() / 60);
        return cost;
    }
}