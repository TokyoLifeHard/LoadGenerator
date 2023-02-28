
import ru.loadgenerator.config.Config;
import ru.loadgenerator.config.ConfigReader;


public class Main {
    public static void main(String[] args) throws Exception {

        ConfigReader configReader = new ConfigReader();
        Config config = configReader.readConfig();
        System.out.println(config.toString());

    }
}
