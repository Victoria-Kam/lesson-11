package com.company;

public class Main {

    public static void main(String[] args) {

        Task.enterData("hellohellohellohel","aaaaaaaa1aaaaaaaaaa","aaaaaaaa1aaaaaaaaaa");
        if(Task.getLoginResult() && Task.getPasswordResult()){
            System.out.println("You have entered correct data!");
        }
    }
}
