package homeWork01.interfaces;

import homeWork01.objects.Person;

/**
 * Created by Prigovor on 25.12.2016.
 */
public interface AddressBook {

    void add(Person person);

    void delete(Person person);
}