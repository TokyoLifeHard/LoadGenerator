package ru.loadgenerator;

import ru.loadgenerator.steps.HttpStep;
import ru.loadgenerator.steps.Step;

import java.util.List;

public class TestPlan {
    List<Step> steps;

    public TestPlan(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}
