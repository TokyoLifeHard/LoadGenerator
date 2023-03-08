package ru.loadgenerator.testplan;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.http.HttpMethod;
import ru.loadgenerator.config.Config;
import ru.loadgenerator.config.elemets.ConfigElement;
import ru.loadgenerator.config.elemets.HttpConfigElement;
import ru.loadgenerator.config.elemets.JdbcConfigElement;
import ru.loadgenerator.credentials.DataBaseCredentials;
import ru.loadgenerator.credentials.HttpCredentials;
import ru.loadgenerator.steps.HttpStep;
import ru.loadgenerator.steps.JdbcStep;
import ru.loadgenerator.steps.Step;

import java.util.ArrayList;

public class TestPlanFactory {

    public static TestPlan createTestPlan(Config config){
        ArrayList<Step> steps = new ArrayList<>(config.getConfigElements().size());
        ArrayList<ConfigElement> configElements = config.getConfigElements();

        for (ConfigElement configElement : configElements) {
            if ("http".equals(configElement.getTypeElement())){
                HttpConfigElement httpConfigElement = (HttpConfigElement) configElement;
                HttpCredentials httpCredentials = new HttpCredentials();
                httpCredentials.setAgent(httpConfigElement.getAgent());
                httpCredentials.setUrl(httpConfigElement.getUrl());
                httpCredentials.setHttpMethod(setHttpMetod(httpConfigElement.getMetod()));
                steps.add(new HttpStep(httpCredentials, new HttpClient()));
            }else if ("jdbc".equals(configElement.getTypeElement())){
                JdbcConfigElement jdbcConfigElement = (JdbcConfigElement) configElement;
                DataBaseCredentials dataBaseCredentials = new DataBaseCredentials();
                dataBaseCredentials.setDataBaseName(jdbcConfigElement.getName());
                dataBaseCredentials.setDataBaseType(jdbcConfigElement.getTypeElement());
                dataBaseCredentials.setPort(jdbcConfigElement.getPort());
                dataBaseCredentials.setUser(jdbcConfigElement.getUsername());
                dataBaseCredentials.setQuery(jdbcConfigElement.getQuery());
                dataBaseCredentials.setHost(jdbcConfigElement.getHost());
                steps.add(new JdbcStep(dataBaseCredentials));
            }
        }
        return new TestPlan(steps);
    }

    private static HttpMethod setHttpMetod(String httpMetod){
        if ("GET".equals(httpMetod)){
            return HttpMethod.GET;
        }else if ("POST".equals(httpMetod)){
            return HttpMethod.POST;
        }else if ("PATCH".equals(httpMetod)){
            return HttpMethod.PATCH;
        } else if ("PUT".equals(httpMetod)){
            return HttpMethod.PUT;
        } else if ("DELETE".equals(httpMetod)) {
            return HttpMethod.DELETE;
        }
        return HttpMethod.GET;
    }
}
