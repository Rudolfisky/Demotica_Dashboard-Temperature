package rudolfisky.demotica_dashboardtemperature_service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;
import rudolfisky.demotica_dashboardtemperature_service.models.Temp;
import rudolfisky.demotica_dashboardtemperature_service.resources.TempDB;
import rudolfisky.demotica_dashboardtemperature_service.services.TempService;

import static org.mockito.Mockito.verify;

@DataJpaTest
public class TempUnitTests {

    @Mock
    private TempDB tempDB;
    private AutoCloseable autoCloseable;
    private TempService underTest;

    //before start of every test
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TempService(tempDB);
    }

    //end of every test
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveTemp() {
        //Assign
        Temp temp = new Temp();
        //Execute
        underTest.saveTemp(temp);
        //Assert
        verify(tempDB).save(temp);
    }

    @Test
    void getTemp() {
        //Execute
        underTest.findAll();
        //Assert
        verify(tempDB).findAll();
    }

    @Test
    void deleteTempById() {
        //Assign
        long id = 1;
        //Execute
        underTest.deleteTempById(id);
        //Assert
        verify(tempDB).deleteById(id);
    }
}
