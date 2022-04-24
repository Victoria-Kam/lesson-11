package com.company;

import com.company.Exceptions.WrongLoginException;
import com.company.Exceptions.WrongPasswordException;

public class Task {

    private static String login;
    private static String password;
    private static String confirmPassword;
    private static final int SIZE = 20;
    private static boolean correctLogin;
    private static boolean correctPassword;

    public static void enterData(String login, String password, String confirmPassword) {
        Task.login = login;
        Task.password = password;
        Task.confirmPassword = confirmPassword;
        try {
            isCorrectLogin();
        } catch (WrongLoginException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        try {
            isCorrectPassword();
        } catch (WrongPasswordException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    private static void isCorrectLogin() throws WrongLoginException {            // проверяем корректность логина

        login = login.trim();

        if ((login.length() > SIZE || areThereGaps())) {
            throw new WrongLoginException("Логин превышает допустимый размер или в логине есть пробелы");
        }

        correctLogin = true;
    }

    private static boolean areThereGaps() {          //проверяем логин на пробелы

        boolean areThereGaps = false;
        String[] str = login.split("");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(" ")) {
                areThereGaps = true;
            }
        }

        return areThereGaps;
    }

    private static void isCorrectPassword() throws WrongPasswordException {      // проверяем корректность пароля

        password = password.trim();

        if (password.length() > SIZE) {
            throw new WrongPasswordException("Пароль превышает допустимый размер");
        } else if (hasAGraps()) {
            throw new WrongPasswordException("В пароле есть пробелы");
        } else if (hasntANumber()) {
            throw new WrongPasswordException("В пароле нету цифр");
        } else if (!isSame()) {
            throw new WrongPasswordException("Подтвержденный пароль не совпадает с веденным паролем");
        }
        correctPassword = true;
    }

    private static boolean hasAGraps() {         // проверяем пароль на наличие пробелов

        boolean isntCorrect = false;
        String temp;
        String[] array = password.split("");

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(" ")) {
                isntCorrect = true;
            }
        }
        return isntCorrect;
    }

    private static boolean hasntANumber() {         // проверяем пароль есть ли цифра

        boolean isntCorrect = true;
        String temp;
        String[] array = password.split("");

        for (int i = 0; i < array.length; i++) {
            if (array[i].matches("\\d+")) {
                isntCorrect = false;
            }
        }
        return isntCorrect;
    }

    private static boolean isSame() {            // проверяем равен ли  password confirmPassword

        return password.equals(confirmPassword);
    }


    public static boolean getLoginResult() {
        return correctLogin;
    }

    public static boolean getPasswordResult() {
        return correctPassword;
    }

}
