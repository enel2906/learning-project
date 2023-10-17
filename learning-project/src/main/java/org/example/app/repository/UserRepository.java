package org.example.app.repository;

import org.example.app.model.User;
import org.example.app.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_ID = "password";
    private static final String NAME_ID = "name";
    private static final String AGE_ID = "age";
    private static final String ROLE_ID = "role";
    private static final String USER_ID = "id";
    private static Map<String, Map<String, Object>> usersMap = new HashMap<>();

    public static String addUser(User user) {
        String id = user.getId();
        Map<String, Object> subMap = convertFromUser(user);

        usersMap.put(id, subMap);
        return id;
    }

    public static void removeUser(String id) {
        usersMap.remove(id);
    }

    public static Object getUsername(String id) {
        return usersMap.get(id).get(USERNAME_ID);
    }

    public static Object getPassword(String id) {
        return usersMap.get(id).get(PASSWORD_ID);
    }

    public static Object getName(String id) {
        return usersMap.get(id).get(NAME_ID);
    }

    public static Object getAge(String id) {
        return usersMap.get(id).get(AGE_ID);
    }

    public static Object getRole(String id) {
        return usersMap.get(id).get(ROLE_ID);
    }

    public static User findUserByID(String id) {
        Map<String, Object> subMap = usersMap.get(id);
        return convertFromEntry(subMap);
    }

    public static User findUserByUsernameAndPassword(String username, String password) {
        for (Map.Entry<String, Map<String, Object>> keyValue : usersMap.entrySet()) {
            String passwordValue = (String) keyValue.getValue().get(PASSWORD_ID);
            String nameValue = (String) keyValue.getValue().get(USERNAME_ID);
            if (password.equals(passwordValue) && username.equals(nameValue)) {
                return convertFromEntry(keyValue.getValue());
            }
        }
        return null;
    }

    public static boolean isValidUsernameAndPassword(String username, String password){
        for (Map.Entry<String, Map<String, Object>> keyValue : usersMap.entrySet()) {
            String passwordValue = (String) keyValue.getValue().get(PASSWORD_ID);
            String nameValue = (String) keyValue.getValue().get(USERNAME_ID);
            if (password.equals(passwordValue) && username.equals(nameValue)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<User> findUserByAge(int age) {
        ArrayList<User> users = new ArrayList<>();
        for (Map.Entry<String, Map<String, Object>> keyValue : usersMap.entrySet()) {
            int ageValue = (int) keyValue.getValue().get(AGE_ID);
            if (age == ageValue) {
                User user = convertFromEntry(keyValue.getValue());
                users.add(user);
            }
        }
        return users;
    }

    public static User convertFromEntry(Map<String, Object> keyValue) {
        String username = (String) keyValue.get(USERNAME_ID);
        String password = (String) keyValue.get(PASSWORD_ID);
        String name = (String) keyValue.get(NAME_ID);
        int age = (int) keyValue.get(AGE_ID);
        String role = (String) keyValue.get(ROLE_ID);
        String id = (String) keyValue.get(USER_ID);
        return new User(username, password, name, age, role, id);
    }

    public static Map<String, Object> convertFromUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String name = user.getName();
        int age = user.getAge();
        String role = user.getRole();
        String id = user.getId();

        Map<String, Object> result = new HashMap<>();
        result.put(USERNAME_ID, username);
        result.put(PASSWORD_ID, password);
        result.put(NAME_ID, name);
        result.put(AGE_ID, age);
        result.put(ROLE_ID, role);
        result.put(USER_ID, id);
        return result;
    }

    public static ArrayList<String> collectKeyInMap() {
        return new ArrayList<>(usersMap.keySet());
    }

    public static void changeAgeOfUser(String id, int ageChange) {
        Map<String, Object> subMap = usersMap.get(id);
        int ageValue = (int) subMap.get(AGE_ID);
        ageValue += ageChange;
        subMap.put(AGE_ID, ageValue);

        usersMap.put(id, subMap);
    }

    public void displayUser(User user) {
        System.out.println(user.toString());
    }

    public static Map<String, Map<String, Object>> getUsersMap() {
        return usersMap;
    }



}