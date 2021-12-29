package rudolfisky.demotica_dashboardtemperature_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import rudolfisky.demotica_dashboardtemperature_service.resources.TempDB;

import java.util.List;

@Service
public class TempService {

    @Autowired
    private TempDB tempDB;

    public TempService(TempDB tempDB) {
        this.tempDB = tempDB;
    }

    public Temp saveTemp(Temp temp){
        return tempDB.save(temp);
    }

    public Iterable<Temp> findAll()  {
        return tempDB.findAll();
    }

    public double getallAvg()  {
        System.out.println("getallAvg()");
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

    public int getRandom()  {
        int randomWithMathRandom = (int) ((Math.random() * (50 - -20)) + -20);

        return randomWithMathRandom;
    }

//    public Iterable<Temp> getWeek()  {
//        System.out.println("getWeek()");
//        List<Temp> temps = tempDB.getPast7Days();
//        double sum = 0;
//        for (Temp temp : temps){
//            sum += temp.getTemp();
//        }
//        double avg = sum / temps.size();
//        avg = avg * 100;
//        avg = Math.round(avg);
//        avg = avg / 100;
//
//        System.out.println(sum);
//        System.out.println(avg);
//        return temps;
//    }

    public double getHour()  {
        List<Temp> temps = tempDB.getPastHour();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        avg = avg * 100;
        avg = Math.round(avg);
        avg = avg / 100;

        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    public double getMinuteAvg()  {
        List<Temp> temps = tempDB.getPastMinute();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        System.out.println(sum);
        System.out.println(avg);
        avg = Math.round(avg * 100) / 100;
        return avg;
    }

    public double get10SecAvg()  {
        List<Temp> temps = tempDB.getPast10sec();
        double sum = 0;
        for (Temp temp : temps){
            sum += temp.getTemp();
        }
        double avg = sum / temps.size();
        avg = avg * 100;
        avg = Math.round(avg);
        avg = avg / 100;

        System.out.println(sum);
        System.out.println(avg);
        return avg;
    }

    public void deleteTempOlderThen1min() {
        tempDB.deleteTempOlderThen1min();
    }

    public void deleteTempById(long id) {
        tempDB.deleteById(id);
    }
}
