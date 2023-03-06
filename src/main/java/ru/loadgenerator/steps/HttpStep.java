package ru.loadgenerator.steps;

import org.eclipse.jetty.client.HttpClient;
import ru.loadgenerator.credentials.HttpCredentials;

import java.util.logging.Logger;

public class HttpStep extends Step implements Runnable{

    HttpClient httpClient;
    HttpCredentials httpCredentials;

    public HttpStep(HttpCredentials httpCredentials, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.httpCredentials = httpCredentials;
    }

    public void execute() {
        try {
            httpClient.start();
            String res = httpClient.newRequest(this.httpCredentials.getUrl())
                    .method(this.httpCredentials.getHttpMethod())
                    .agent(httpCredentials.getAgent())
                    .send().getContentAsString();
            httpClient.stop();
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void run() {
        execute();
    }
}
