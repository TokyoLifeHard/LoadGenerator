package ru.loadgenerator.steps;

public abstract class Step {
    private Protocol protocol;


    public Step(Protocol protocol) {
        this.protocol = protocol;
    }

    public abstract void execute();

}