package rudolfisky.demotica_dashboardtemperature_service.resources;

import rudolfisky.demotica_dashboardtemperature_service.models.Daily;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface TempDB extends CrudRepository<Temp, Long> {
//    List<Daily> findByCompleteDtBetween(final LocalDateTime startDate, final LocalDateTime endDate);

    @Query(
            value = "SELECT * FROM temp WHERE TIMESTAMPDIFF(DAY, timestamp, NOW()) <= 7",
            nativeQuery = true)
    List<Temp> getPast7Days();

    @Query(
            value = "SELECT * FROM temp WHERE TIMESTAMPDIFF(HOUR, timestamp, NOW()) <= 1",
            nativeQuery = true)
    List<Temp> getPastHour();

    @Query(
            value = "SELECT * FROM temp WHERE TIMESTAMPDIFF(SECOND, timestamp, NOW()) <= 60",
            nativeQuery = true)
    List<Temp> getPastMinute();

    @Query(
            value = "SELECT * FROM temp WHERE TIMESTAMPDIFF(SECOND, timestamp, NOW()) <= 10",
            nativeQuery = true)
    List<Temp> getPast10sec();

}
