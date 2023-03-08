import ru.loadgenerator.TestPlan;
import ru.loadgenerator.TestPlanFactory;
import ru.loadgenerator.config.Config;
import ru.loadgenerator.config.ConfigReader;
import ru.loadgenerator.steps.Step;

import java.util.List;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws Exception {

        ConfigReader configReader = new ConfigReader();
        Config config = configReader.readConfig();
        System.out.println(config.toString());
        TestPlan testPlan = TestPlanFactory.createTestPlan(config);

        List<Step> steps = testPlan.getSteps();
        for (Step step : steps) {
            System.out.println(step.toString());
        }

    }
}
