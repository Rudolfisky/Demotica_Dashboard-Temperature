package rudolfisky.demotica_dashboardtemperature_service.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

@Configuration
@EnableScheduling
public class Schedule {
    // https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions for more on cron
//    @Scheduled(fixedDelay = 10000)
//    public void scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 10000);
//    }
    @Scheduled(cron = "0 */59 * * * *", zone = "Europe/Paris")
    public void scheduleCompileHour() {
        System.out.println(LocalTime.now() + ": scheduleCompileHour");
    }
    @Scheduled(cron = "0 * * * * *", zone = "Europe/Paris")
    public void scheduleCompileMinute() {
        System.out.println(LocalTime.now() + ": CompileMinute");
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "Europe/Paris")
    public void scheduleClearMinute() {
        System.out.println(LocalTime.now() + ": Delete minute that is older then 2 days");
    }

    @Scheduled(cron = "0 */10 * * * *", zone = "Europe/Paris")
    public void scheduleClearTemp() {
        System.out.println(LocalTime.now() + ": Delete temp that is older then 10 min");
    }
//    @Scheduled(cron = "* * * * * *", zone = "Europe/Paris")
//    public void scheduleCompileSecond() {
//        System.out.println("CompileSecond");
//    }
}
