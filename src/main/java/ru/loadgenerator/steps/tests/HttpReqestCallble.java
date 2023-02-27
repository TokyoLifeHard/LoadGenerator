package ru.loadgenerator.steps.tests;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import java.util.concurrent.Callable;

public class HttpReqestCallble implements Callable<String> {

    private String url;
    private HttpClient httpClient;
    public HttpReqestCallble(String url, HttpClient httpClient) {
        this.url = url;
        this.httpClient = httpClient;
    }

    private String send() throws Exception {
        this.httpClient.start();
        ContentResponse send = httpClient.newRequest("http://www.boredapi.com/api/activity")
                .method(HttpMethod.GET)
                .agent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:17.0) Gecko/20100101 Firefox/17.0")
                .send();
        this.httpClient.stop();
        return send.getContentAsString();
    }

    @Override
    public String call() throws Exception {
        return send();
    }
}
