package ru.loadgenerator.steps;

import org.eclipse.jetty.client.HttpClient;
import ru.loadgenerator.credentials.HttpCredentials;

import java.util.concurrent.Callable;

public class HttpStep extends Step implements Callable<String> {

    HttpClient httpClient;
    HttpCredentials httpCredentials;

    public HttpStep(HttpCredentials httpCredentials, HttpClient httpClient) {
        this.httpClient = httpClient;
        this.httpCredentials = httpCredentials;
    }

    public String execute() {
        StringBuilder resp = new StringBuilder();
        try {
            httpClient.start();
            String res = httpClient.newRequest(this.httpCredentials.getUrl())
                    .method(this.httpCredentials.getHttpMethod())
                    .agent(httpCredentials.getAgent())
                    .send().getContentAsString();
            httpClient.stop();
            resp.append(res);
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return resp.toString();
    }

    @Override
    public String call() throws Exception {
        return execute();
    }

    @Override
    public String toString() {
        return "HttpStep{" +
                "httpClient=" + httpClient +
                ", httpCredentials=" + httpCredentials +
                '}';
    }
}
