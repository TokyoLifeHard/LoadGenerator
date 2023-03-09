package ru.loadgenerator.loadrunner;

import ru.loadgenerator.steps.Step;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


public class LoadRunner {

    ExecutorService executorService;
    List<Step> steps;

    public LoadRunner(ExecutorService executorService, List<Step> steps) {
        this.executorService = executorService;
        this.steps = steps;
    }

    public void run() throws InterruptedException, ExecutionException {
        while (true){
            for (Step step : steps) {
                Future<Object> submit = this.executorService.submit(step);
                System.out.println(submit.get());
            }
        }
    }

}
