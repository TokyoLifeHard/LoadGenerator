import ru.loadgenerator.config.Config;
import ru.loadgenerator.config.ConfigReader;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws Exception {

        ConfigReader configReader = new ConfigReader();
        Config config = configReader.readConfig();
        System.out.println(config.toString());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);


    }
}
