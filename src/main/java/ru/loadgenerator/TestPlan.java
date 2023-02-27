package ru.loadgenerator;


import ru.loadgenerator.steps.HttpStep;

import java.util.List;

public class TestPlan {
    List<HttpStep> httpSteps;

    public TestPlan(List<HttpStep> httpSteps) {
        this.httpSteps = httpSteps;
    }

    public List<HttpStep> getHttpSteps() {
        return httpSteps;
    }

    public void setHttpSteps(List<HttpStep> httpSteps) {
        this.httpSteps = httpSteps;
    }
}
