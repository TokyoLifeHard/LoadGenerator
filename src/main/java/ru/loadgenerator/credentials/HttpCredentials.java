package ru.loadgenerator.credentials;

import org.eclipse.jetty.http.HttpMethod;

import java.util.Map;

public class HttpCredentials {
    private String url;
    private HttpMethod httpMethod;

    private String agent;

    private String body;

    private Map<String,String> params;

    public HttpCredentials() {
    }

    public HttpCredentials(String url, HttpMethod httpMethod, String agent, String body) {
        this.url = url;
        this.httpMethod = httpMethod;
        this.agent = agent;
        this.body = body;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HttpCredentials{" +
                "url='" + url + '\'' +
                ", httpMethod=" + httpMethod +
                ", agent='" + agent + '\'' +
                ", body='" + body + '\'' +
                ", params=" + params +
                '}';
    }
}
