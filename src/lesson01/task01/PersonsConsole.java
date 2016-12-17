package lesson01.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 17.12.2016.
 */

public class PersonsConsole {

    private Scanner scanner;
    private List<Person> persons;

    public PersonsConsole() {
        scanner = new Scanner(System.in);
        persons = new ArrayList<>();
    }

    public void start() throws IOException {
        int choice = 0;
        do {
            menu();
            choice = getIntegerParam("Выберите действие (1-5): ");
            switch (choice) {
                case 1 : {
                    Person person = registPerson();
                    persons.add(person);
                    break;
                }
                case 2 : {
                    printAllPersons();
                    break;
                }
                case 3 : {
                    File file = new File(getStringParam("Введите путь:"));
                    if (!file.exists()) file.createNewFile();
                    savePersonsToDataFile(file);
                    break;
                }
            }
        } while (choice != 5);
    }

    private void menu() {
        System.out.println("Меню: \n1. Зарегистрировать нового человека." +
                                 "\n2. Вывести список зарегистрированых людей.");
    }

    private Person registPerson() {
        String name    = getStringParam("Введите имя:");
        String surname = getStringParam("Введите фамилию:");
        String date    = getStringParam("Введите дату рождения:");
        Integer age    = getIntegerParam("Введите возраст:");
        return new Person(name, surname, age, date);
    }

    private void printAllPersons() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private void savePersonsToDataFile(File data) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(data))) {
            oos.writeObject(persons);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStringParam(String text) {
        System.out.print(text);
        return scanner.next();
    }

    private Integer getIntegerParam(String text) {
        System.out.print(text);
        while (!scanner.hasNextInt()) {
            System.out.print("Неверный ввод: " + scanner.next() + "Попробуйте еще: ");
        }
        return scanner.nextInt();
    }
}
