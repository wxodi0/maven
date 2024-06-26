package sh.love.jpa.domain;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "fine_dust")
public class FineDust {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String checkData;
    private String checkTime;
    private String area;
    private String ground;
    private String roadName;
    private String startPoint;
    private String endPoint;
    private int temp;
    private int hum;
    private int AverageAshDustConcentration;
    private String Legend;
}
