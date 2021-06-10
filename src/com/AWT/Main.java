package com.AWT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main { // property - как map только через файл

    static void SaveProperties() throws IOException {
        Properties property = new Properties(); // наш пропертис
        property.setProperty("db.host","http://localhost:8888/mydb"); // сохраняем его значения
        property.setProperty("db.login","root");
        property.setProperty("db.password","dbroot");

        // что мы сохраняем, объяснение
        System.out.println("Save: "+property.getProperty("db.host")+" "+property.getProperty("db.login")+" "+property.getProperty("db.password"));

        // сохранение в файл
        FileOutputStream out = new FileOutputStream("config.property");
        property.store(out, "my comment");
    }

    public static void main(String[] args) throws IOException {
        SaveProperties(); // наше сохранение
        System.out.println("-----");
        LoadProperties(); // наша загрузка
    }

    static void LoadProperties(){
        // поток из файла
        FileInputStream fis;
        Properties property = new Properties(); // новый пропертис

        try {
            fis = new FileInputStream("config.property"); // файл с данными
            property.load(fis);// оправляем его значения в пропертис

            String host = property.getProperty("db.host"); // выгружаем значения в переменные
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");

            // проверяем, что всё работает
            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!"); // ошибка
        }
    }
}
