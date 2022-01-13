package sh.love.jpa.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "main")
public class Main {

    @Id
    private int sn;

    @Column
    private String cn;

}
