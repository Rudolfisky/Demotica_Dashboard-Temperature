package rudolfisky.demotica_dashboardtemperature_service.controllers;

import rudolfisky.demotica_dashboardtemperature_service.models.Daily;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import rudolfisky.demotica_dashboardtemperature_service.models.Temps;
import rudolfisky.demotica_dashboardtemperature_service.resources.TempDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/temps")
public class TempController {
    @Autowired
    private TempDB tempDB;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Temp> getAll()  {
        return tempDB.findAll();
    }

    @GetMapping(path="/average/all")
    public @ResponseBody Double getallAvg()  {
        Iterable<Temp> temps = tempDB.findAll();

        double sum = 0;
        int count = 0;
        for (Temp temp : temps) {
            sum += temp.getTemp();
            count += 1;
        }
        double avg = sum / count;
        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    @GetMapping(path="/test/reandom")
    public @ResponseBody int getRandom()  {
        int randomWithMathRandom = (int) ((Math.random() * (50 - -20)) + -20);

        return randomWithMathRandom;
    }

    @GetMapping(path="/past/7days")
    public @ResponseBody Iterable<Temp> getWeek()  {
        List<Temp> temps = tempDB.getPast7Days();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        System.out.println(sum);
        System.out.println(avg);
        return temps;
    }

    @GetMapping(path="/average/hour")
    public @ResponseBody Double getHour()  {
        List<Temp> temps = tempDB.getPastHour();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    @GetMapping(path="/average/minute")
    public @ResponseBody Double getMinuteAvg()  {
        List<Temp> temps = tempDB.getPastMinute();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    @GetMapping(path="/average/10sec")
    public @ResponseBody Double get10SecAvg()  {
        List<Temp> temps = tempDB.getPast10sec();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    @GetMapping(value = "/message")
    @ResponseBody
    public String message() {

        return "Hello there!";
    }
//    @PostMapping(path="/add")
//    public @ResponseBody Iterable<Daily> getWeek()  {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        Iterable<Daily> dailies = tempDB.findAll();
//        dailies.forEach(System.out::println);
//
//        return dailies;
//
//    }
}
