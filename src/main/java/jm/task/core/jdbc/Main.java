package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println("Таблица User(ов) создана");

        userService.saveUser("Nika", "Darbinyan", (byte) 22);
        System.out.println("User с именем - Nika добавлен в базу данных");

        userService.saveUser("Ivan", "Ivanov", (byte) 25);
        System.out.println("User с именем - Ivan добавлен в базу данных");

        userService.saveUser("Pedro", "Rossi", (byte) 31);
        System.out.println("User с именем - Pedro добавлен в базу данных");

        userService.saveUser("Francesca", "Marino", (byte) 38);
        System.out.println("User с именем - Francesca добавлен в базу данных");

        System.out.println("Все пользователи:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

        //Util.closeConnection(Util.getConnection());
        Util.closeSessionFactory(Util.getSessionFactory());
    }
}
