package ru.loadgenerator.config;

import ru.loadgenerator.config.elemets.ConfigElement;

import java.util.ArrayList;

public class Config {
    private ArrayList<ConfigElement> configElements;

    public Config() {
        this.configElements = new ArrayList<>();
    }

    public void addConfigElemet(ConfigElement configElement) {
        this.configElements.add(configElement);
    }

    @Override
    public String toString() {
        return "Config{" +
                "configElements=" + configElements +
                '}';
    }
}
