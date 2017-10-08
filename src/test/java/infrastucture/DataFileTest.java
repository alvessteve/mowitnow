package infrastucture;

import org.junit.Before;
import org.junit.Test;
import org.xebia.mowitnow.application.DataService;
import org.xebia.mowitnow.infrastructure.di.DependencyInjector;

public class DataFileTest {

    private DataService dataService;

    @Before
    public void setup(){
        dataService = DependencyInjector.newDataService();
    }

    @Test(expected = IllegalStateException.class)
    public void wront_path(){
        dataService.readFile("/toto");
    }

    @Test
    public void correct_path(){
        dataService.readFile("./src/test/resources/mows.txt");
    }

}
