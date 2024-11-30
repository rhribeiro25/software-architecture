package br.com.rhribeiro25.infra.controller;

import java.util.Scanner;

public class PromptController {

    private Scanner scanner;
    private final String userHome = System.getProperty("user.home").replace("\\", "/");

    public PromptController() {
        scanner = new Scanner(System.in);
    }

    public String getPathInput(String msg) {
        System.out.print(msg);
        String path = scanner.nextLine();
        return userHome + "/" + path;
    }

    public String getNameInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int getDepartmentInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getRoleInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getMenuInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getSearchInput(String msg) {
        System.out.print(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

}