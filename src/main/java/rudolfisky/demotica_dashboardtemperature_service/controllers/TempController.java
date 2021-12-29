package rudolfisky.demotica_dashboardtemperature_service.controllers;

import org.springframework.web.bind.annotation.*;
import rudolfisky.demotica_dashboardtemperature_service.models.Daily;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import rudolfisky.demotica_dashboardtemperature_service.models.Temps;
import rudolfisky.demotica_dashboardtemperature_service.resources.TempDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import rudolfisky.demotica_dashboardtemperature_service.services.TempService;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.0.67:3000"})
@RequestMapping(path="/temps")
public class TempController {
//    @Autowired
//    private TempDB tempDB;
    @Autowired
    private TempService service;

//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<Temp> getAll()  {
//        return service.findAll();
//    }

    @GetMapping(path="/average/all")
    public @ResponseBody double getallAvg()  {
        return service.getallAvg();
    }

    @GetMapping(path="/test/random")
    public @ResponseBody int getRandom()  {
        return service.getRandom();
    }

//    @GetMapping(path="/past/7days")
//    public @ResponseBody Iterable<Temp> getWeek()  {
//        return service.getWeek();
//    }

    @GetMapping(path="/average/hour")
    public @ResponseBody double getHour()  {
        return service.getHour();
    }

    @GetMapping(path="/average/minute")
    public @ResponseBody double getMinuteAvg()  {
        return service.getMinuteAvg();
    }

    @GetMapping(path="/average/10sec")
    public @ResponseBody double get10SecAvg()  {
        return service.get10SecAvg();
    }

    @GetMapping(value = "/message")
    @ResponseBody
    public String message() {

        return "Hello there!";
    }
    @DeleteMapping(value = "/cleartemp")
    public void deleteTempOlderThen1min() {
        service.deleteTempOlderThen1min();
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
