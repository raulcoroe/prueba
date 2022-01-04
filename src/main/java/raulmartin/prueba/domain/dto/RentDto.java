package raulmartin.prueba.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import raulmartin.prueba.domain.Bike;
import raulmartin.prueba.domain.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalDateTime;

import static java.lang.Math.abs;

@Data
@NoArgsConstructor
public class RentDto {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endDate;
    private boolean active;
    private float cost;
    private long user;
    private long bike;

    public RentDto(LocalDateTime startDate, LocalDateTime endDate, boolean active, long user, long bike) {

        float COST_PER_MINUTE = (float) 0.10;
        Duration duration = Duration.between(startDate, endDate);

        this.cost = abs(COST_PER_MINUTE * (duration.getSeconds() / 60));
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.user = user;
        this.bike = bike;
    }
}
