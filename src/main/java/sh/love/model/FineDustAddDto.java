package sh.love.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FineDustAddDto {
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
