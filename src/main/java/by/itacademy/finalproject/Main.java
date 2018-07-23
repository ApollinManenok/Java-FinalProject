package by.itacademy.finalproject;

import by.itacademy.finalproject.domain.Administrator;
import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.RangeException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        School school = new School("Stars");
        Administrator admin = new Administrator(school);
        try {
            admin.list();
        } catch (RangeException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
