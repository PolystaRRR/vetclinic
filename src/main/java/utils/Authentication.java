package utils;

import java.util.Scanner;

public class Authentication {
    public static final String LOGIN = "pavel";
    public static final String PASSWORD = "111";

    public static boolean auth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        return login.equals(LOGIN) & password.equals(PASSWORD);
    }
}
