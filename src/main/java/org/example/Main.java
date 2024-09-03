package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(i, rnd.nextInt(10, 1000));
        }
        System.out.println(numbers);
        List<Integer> numbersMoreThan500 =  numbers.stream().filter(n -> (n > 500)).collect(Collectors.toList());
        System.out.println(numbersMoreThan500);
        long countOfOdd = numbers.stream().filter(c -> (c % 2 == 1)).count();
        System.out.println(countOfOdd);

        List<String> words = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            words.add(i, UUID.randomUUID().toString());
        }
        System.out.println(words);

        List<String> wordsPlusPalindrom = words.stream().map(n -> {
            String result = "";
            for (int i = 0; i < n.length(); i++) {
                result = n.charAt(i) + result;
            }
            return n + result;
        }).collect(Collectors.toList());
        System.out.println(wordsPlusPalindrom);

        Phone phone1 = new Phone(95869805, "Stationary");
        Phone phone2 = new Phone(134217727, "Mobile");
        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);

        List<User> users = new ArrayList<>();
        for (int i = 0; i <=10 ; i++) {
            User user = new User(rnd.nextInt(10, 50),
                    UUID.randomUUID().toString(),
                    rnd.nextInt(18, 50),
                    phones);
            users.add(user);
        }
        System.out.println(users);

        List<User> oldUsers = users.stream().filter(n -> {
            for (Phone p : n.getPhone()){
                return p.getTypeOfPhone().equals("Stationary");
            }
            return false;
        }).max(Comparator.comparing(User::getAge)).stream().toList();
        System.out.println("Старые пользователи " + oldUsers);
    }
}