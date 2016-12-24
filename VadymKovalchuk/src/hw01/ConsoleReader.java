package hw01;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eriol4ik on 17/12/2016.
 */
public class ConsoleReader {
    private Scanner scanner;
    private ArrayList<Person> people;
    private final int EXIT = 8;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
        people = new ArrayList<>();
    }

    public void start() throws IOException {
        int option = 0;
        while (option != EXIT) {
            showMenu();
            option = getInputtedInt("Your choice: ");

            switch (option) {
                case 1:
                    people.add(newPerson());
                    break;
                case 2:
                    showRegisteredPeople();
                    break;
                case 3:
                    writeToFile();
                    break;
                case 4:
                    readFromFile();
                    break;
                case 5:
                    searchPerson();
                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    if (!people.isEmpty() && getInputtedString("Save to file? Y/N: ").equals("Y")) writeToFile();
                    break;
                default:
                    System.out.print("Please choose 1-6.");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:\n" +
                           "1. Register new person\n" +
                           "2. Show all registered people\n" +
                           "3. Write to file...\n" +
                           "4. Read from file...\n" +
                           "5. Search a person\n" +
                           "6. Search by name\n" +
                           "7. Search by surname\n" +
                           "8. Exit"
        );
    }

    private Person newPerson() {
        String name;
        String surname;
        int age;
        String date;

        name = getInputtedString("Type name: ");
        surname = getInputtedString("Type surname: ");
        age = getInputtedInt("Type age: ");
        date = getInputtedString("Type date: ");

        return new Person(name, surname, age, date);
    }

    private void showRegisteredPeople() {
        if (people.size() == 0) {
            showResult("No registered people.");
            return;
        }
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
                  sb.append(++counter)
                    .append(". ")
                    .append(person)
                    .append("\n");
        }
        showResult(sb.toString());
    }

    private void writeToFile() {
        if (people.isEmpty()) {
            System.out.println("Empty data.");
            return;
        }
        File file = new File(System.getProperty("user.dir") + "\\files\\" + getInputtedString("Type a name of new file: %project_dir%\\files\\"));
        if (file.exists() && getInputtedString("Override file? Y/N: ").equals("N")) return;
        if (!file.exists()) {
            try {
                file.createNewFile();
                ObjectOutputStream oos;
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(people);
                oos.flush();
                oos.close();
                showResult("Successfully written!");
            } catch (IOException e) {
                showResult("Bad path");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void readFromFile() {
        File file = new File(System.getProperty("user.dir") + "\\files\\" + getInputtedString("Type a name of the file: %project dir%\\files\\"));
        if (file.exists()) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Object obj = ois.readObject();
                people.addAll((ArrayList<Person>) obj);
                showResult("Successfully read!");
            } catch (ClassNotFoundException cnfe) {
                showResult("Class not found.");
            } catch (IOException ioe) {
                showResult("Wrong input stream.");
            }
        }
    }

    private void searchPerson() {
        Person searchingPerson = newPerson();
        for (int i = 0; i < people.size(); i++) {
            if (searchingPerson.equals(people.get(i))) {
                showResult("Success! The person is in the list:\n" + (i + 1) + ". " + people.get(i));
                return;
            }
        }
        showResult("No such person.");
    }

    private void searchByName() {
        String name = getInputtedString("Type a name: ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
            sb.append("Success! All found person:\n");
            if (name.equals(people.get(i).getName())) {
                sb.append(i + 1).append(". ").append(people.get(i)).append("\n");
            }
        }
    }

    private void searchBySurname() {
        String surname = getInputtedString("Type a surname: ");
    }

    private void showResult(String s) {
        System.out.println("---------------------------------------");
        System.out.println(s);
        System.out.println("---------------------------------------");
    }

    private String getInputtedString(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    private int getInputtedInt(String s) {
        Integer input = null;
        System.out.print(s);
        while (input == null) {
            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Please type a number: ");
            }
        }
        return input;
    }
}
