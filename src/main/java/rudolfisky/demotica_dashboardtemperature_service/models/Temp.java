package rudolfisky.demotica_dashboardtemperature_service.models;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Temp {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationDateTime;

    private Double temp;

    public Temp() {
    }

    public Temp(Double temp) {
        this.temp = temp;
    }

    public LocalDateTime getDate() {
        return creationDateTime;
    }

    public void setDate(LocalDateTime date) {
        this.creationDateTime = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
