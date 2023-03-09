package ru.loadgenerator.steps;

import java.util.concurrent.Callable;

public abstract class Step implements Callable<Object> {
    public abstract <T> T execute();
}