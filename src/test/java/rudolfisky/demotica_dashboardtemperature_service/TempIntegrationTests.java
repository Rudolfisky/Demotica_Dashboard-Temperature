package rudolfisky.demotica_dashboardtemperature_service;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import org.springframework.http.HttpHeaders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TempIntegrationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String tempUrl;
    private HttpHeaders headers;
    private JSONObject tempPostObject;

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

//    @Test
//    void getAverageTempAll() {
//        ResponseEntity result = testRestTemplate.getForEntity(tempUrl+"/average/all", Temp.class);
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(result.getStatusCode(), HttpStatus.OK);
//    }

}
