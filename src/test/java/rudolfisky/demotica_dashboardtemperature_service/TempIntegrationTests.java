package rudolfisky.demotica_dashboardtemperature_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class TempIntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String tempUrl;
    private HttpHeaders headers;
    private JSONObject tempPostObject;
    private Object List;

    //before start of every test
    @BeforeEach
    void setUp() {
        tempUrl = "/temps";
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        tempPostObject = new JSONObject();
        tempPostObject.put("creationDateTime", "2021-11-12 12:34:56");
        tempPostObject.put("temp", "20");
    }

    @Test
    void getallAvg() {
        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/average/all", Temp.class);
        Assertions.assertNotNull(result);
        System.out.println("result");
        System.out.println(result.getBody().toString());
        System.out.println(result.getBody().getClass());
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getRandom() {
        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/test/random", Integer.class);
        Assertions.assertNotNull(result);
        System.out.println("result");
        System.out.println(result.getBody().toString());
        System.out.println(result.getBody().getClass());
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
//    @Test
//    void getWeek() {
//        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/past/7days", Temps.class);
//        Assertions.assertNotNull(result);
//        System.out.println("result");
//        System.out.println(result.getBody().toString());
//        System.out.println(result.getBody().getClass());
//        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
//    }
    @Test
    void getHour() {
        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/average/hour", Temp.class);
        Assertions.assertNotNull(result);
        System.out.println("result");
        System.out.println(result.getBody().toString());
        System.out.println(result.getBody().getClass());
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getMinuteAvg() {
        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/average/minute", Temp.class);
        Assertions.assertNotNull(result);
        System.out.println("result");
        System.out.println(result.getBody().toString());
        System.out.println(result.getBody().getClass());
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void get10SecAvg() {
        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/average/10sec", Temp.class);
        Assertions.assertNotNull(result);
        System.out.println("result");
        System.out.println(result.getBody().toString());
        System.out.println(result.getBody().getClass());
        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

}
