package ru.loadgenerator.config;

import org.yaml.snakeyaml.Yaml;
import ru.loadgenerator.config.elemets.HttpConfigElement;
import ru.loadgenerator.config.elemets.JdbcConfigElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.*;

public class ConfigReader {
    private static final String CURRENT_DIR = getProperty("user.dir");
    private static final File CONFIG = new File(CURRENT_DIR + "\\" + "config.yaml");
    private Yaml yaml;

    public ConfigReader() {
        this.yaml = new Yaml();
    }

    public Config readConfig() throws FileNotFoundException {
        Config configList = new Config();
        Map<String, Object> data = yaml.load(new FileInputStream(CONFIG));
        Object[] list = data.values().toArray();
        ArrayList<LinkedHashMap<String, LinkedHashMap<String, String>>> config = (ArrayList) list[0];
        for (LinkedHashMap<String, LinkedHashMap<String, String>> configSteps : config) {
            Set<Map.Entry<String, LinkedHashMap<String, String>>> step = configSteps.entrySet();
            for (Map.Entry<String, LinkedHashMap<String, String>> prop : step) {
                if (prop.getKey().equals("http")) {
                    configList.addConfigElemet(createHttpConfigElement(prop));
                } else {
                    configList.addConfigElemet(createJdbcConfigElement(prop));
                }
            }

        }
        return configList;
    }

    private HttpConfigElement createHttpConfigElement(Map.Entry<String, LinkedHashMap<String, String>> prop) {
        HttpConfigElement httpConfigElement = new HttpConfigElement();
        httpConfigElement.setTypeElement("http");
        LinkedHashMap<String, String> props = prop.getValue();
        Set<Map.Entry<String, String>> entries = props.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().equals("url")) {
                httpConfigElement.setUrl(entry.getValue());
            } else if (entry.getKey().equals("metod")) {
                httpConfigElement.setMetod(entry.getValue());
            } else {
                httpConfigElement.setAgent(entry.getValue());
            }
        }

        return httpConfigElement;
    }

    private JdbcConfigElement createJdbcConfigElement(Map.Entry<String, LinkedHashMap<String, String>> prop) {
        JdbcConfigElement jdbcConfigElement = new JdbcConfigElement();
        jdbcConfigElement.setTypeElement("jdbc");
        LinkedHashMap<String, String> props = prop.getValue();
        Set<Map.Entry<String, String>> entries = props.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().equals("database")) {
                jdbcConfigElement.setDatabase(entry.getValue());
            } else if (entry.getKey().equals("host")) {
                jdbcConfigElement.setHost(entry.getValue());
            } else if (entry.getKey().equals("port")) {
                jdbcConfigElement.setPort(String.valueOf(entry.getValue()));
            } else if (entry.getKey().equals("username")) {
                jdbcConfigElement.setUsername(entry.getValue());
            } else if (entry.getKey().equals("password")) {
                jdbcConfigElement.setPassword(entry.getValue());
            } else if (entry.getKey().equals("name")) {
                jdbcConfigElement.setName(entry.getValue());
            } else {
                jdbcConfigElement.setQuery(entry.getValue());
            }

        }
        return jdbcConfigElement;
    }
}
