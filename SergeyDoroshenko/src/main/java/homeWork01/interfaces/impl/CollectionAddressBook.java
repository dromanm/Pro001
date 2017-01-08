package homeWork01.interfaces.impl;

import homeWork01.interfaces.AddressBook;
import homeWork01.objects.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Prigovor on 25.12.2016.
 */
public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print(){
        int number = 0;
        System.out.println();
        for(Person person : personList){
            number++;
        }
    }
}
