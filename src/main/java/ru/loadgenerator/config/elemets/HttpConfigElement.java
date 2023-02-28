package ru.loadgenerator.config.elemets;

public class HttpConfigElement extends ConfigElement {
    private String url;
    private String metod;
    private String agent;

    public HttpConfigElement(String typeElement, String url, String metod, String agent) {
        super(typeElement);
        this.url = url;
        this.metod = metod;
        this.agent = agent;
    }

    public HttpConfigElement() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMetod() {
        return metod;
    }

    public void setMetod(String metod) {
        this.metod = metod;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "HttpConfigElement{" +
                "url='" + url + '\'' +
                ", metod='" + metod + '\'' +
                ", agent='" + agent + '\'' +
                ", typeElement='" + typeElement + '\'' +
                '}';
    }

    @Override
    public void setTypeElement(String typeElement) {
        super.setTypeElement(typeElement);
    }
}
