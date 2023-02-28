package ru.loadgenerator.config.elemets;

public class JdbcConfigElement extends ConfigElement{
    private String database;
    private String host;
    private String port;
    private String username;
    private String password;
    private String name;
    private String query;

    public JdbcConfigElement(String typeElement, String database, String host, String port, String username, String password, String name, String query) {
        super(typeElement);
        this.database = database;
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.name = name;
        this.query = query;
    }

    public JdbcConfigElement() {
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public void setTypeElement(String typeElement) {
        super.setTypeElement(typeElement);
    }

    @Override
    public String toString() {
        return "JdbcConfigElement{" +
                "database='" + database + '\'' +
                ", host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", query='" + query + '\'' +
                '}';
    }

}
