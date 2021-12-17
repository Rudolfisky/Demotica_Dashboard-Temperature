package rudolfisky.demotica_dashboardtemperature_service.models;



import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Daily {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationDateTime;

    private Double temp;

//    public DailyTemp(Timestamp date, double temp) {
//        this.date = date;
//        this.temp = temp;
//    }


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
