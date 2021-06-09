package com.AWT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    static void SaveProperties() throws IOException {
        Properties property = new Properties();
        property.setProperty("db.host","http://localhost:8888/mydb");
        property.setProperty("db.login","root");
        property.setProperty("db.password","dbroot");
        System.out.println("Save: "+property.getProperty("db.host")+" "+property.getProperty("db.login")+" "+property.getProperty("db.password"));
        FileOutputStream out = new FileOutputStream("config.property");
        property.store(out, "my comment");
    }

    public static void main(String[] args) throws IOException {
        SaveProperties();
        System.out.println("-----");
        LoadProperties();
    }

    static void LoadProperties(){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("config.property");
            property.load(fis);

            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
