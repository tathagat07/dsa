package dev.tries;

import dev.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("John", 25);
        System.out.println(user.name() + " " + user.age());
    }
}
