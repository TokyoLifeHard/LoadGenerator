package ru.loadgenerator.credentials;
public class DataBaseCredentials {
    String dataBaseType;
    String dataBaseName;
    String host;
    String port;
    String user;
    String password;
    private DataBaseCredentials(Builder builder) {
        this.dataBaseType = builder.dataBaseType;
        this.dataBaseName = builder.dataBaseName;
        this.host = builder.host;
        this.port = builder.port;
        this.user = builder.user;
        this.password = builder.password;
    }
     public static class Builder{
        private String dataBaseType;
        private String dataBaseName;
        private String host;
        private String port;
        private String user;
        private String password;



         public Builder setDataBaseType(String dataBaseType) {
             this.dataBaseType = dataBaseType;
             return this;
         }

         public Builder setDataBaseName(String dataBaseName) {
             this.dataBaseName = dataBaseName;
             return this;
         }

         public Builder setHost(String host) {
             this.host = host;
             return this;
         }

         public Builder setPort(String port) {
             this.port = port;
             return this;
         }

         public Builder setUser(String user) {
             this.user = user;
             return this;
         }

         public Builder setPassword(String password) {
             this.password = password;
             return this;
         }

         public DataBaseCredentials build(){
             return new DataBaseCredentials(this);
         }
     }


}
