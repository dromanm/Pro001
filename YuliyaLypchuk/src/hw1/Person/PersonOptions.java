package hw1.Person;

import javafx.scene.control.ListView;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

/**
 * Created by Comfy on 17.12.2016.
 */
public class PersonOptions {

    private Scanner scan;
    private List<Person> persons;

    public PersonOptions() {
        scan = new Scanner(System.in);
        persons = new ArrayList<>();
    }

    public  void start() throws IOException {
        int choice = 0;

        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    printPersons();
                    break;
                case 3:
                    saveDataPersons(getPathFile());
                    break;
                case 4:
                    openDataPerson(getPathFile());
                    break;
                case 5:
                    findPerson();
                    break;
            }
        } while (choice != 0);
    }

    private int getChoice() {
        System.out.println("Choose option: ");
        System.out.println(" 1 - create a person;" +
                "\n 2 - show all person" +
                "\n 3 - save data in a file" +
                "\n 4 - open data from the file" +
                "\n 5 - find the person" +
                "\n 0 - exit");
        int choice = scan.nextInt();
        if (choice >= 0 && choice < 6 ) {
            return choice;
        } else {
            System.out.println("Incorrect code of option.");
        }
        return 0;
    }

    private  void addPerson() {
        System.out.println("Enter a person's name, surname, age(number) and birthday:");
        Person person = new Person(scan.next(), scan.next(), scan.nextInt(), scan.next());
        persons.add(person);
    }

    private void printPersons() {
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    private  void saveDataPersons(File file ) {
        try (FileOutputStream fis = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fis)) {
            oos.writeObject(persons);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getPathFile() throws IOException {
        System.out.println("Enter path (for example D:/IdeaProjects/Prof001/Person ):");
        File local = new File(scan.next());

        System.out.println("Enter name of file (for example list.dat ):");
        File file = new File(local, scan.next());

        if (!file.exists()) {
            System.out.println("File is not exists! Creating a new file.");
            file.createNewFile();
        }
        return file;
    }

    private void openDataPerson(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Person> list = (List<Person>) ois.readObject();
            System.out.println(list.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void findPerson() {
        System.out.println("Enter name or surname for search: ");
        String searchPerson = scan.next();
        boolean findMarker = false;
        for (Person person : persons) {
            if (searchPerson.equals(person.getName()) || searchPerson.equals(person.getSurname())){
                System.out.println("Person found: " + person.toString());
                findMarker = true;
            }
        }
        if (!findMarker)  System.out.println("Not found!");
    }
}
