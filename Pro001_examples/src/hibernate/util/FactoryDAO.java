package hibernate.util;

import hibernate.dao.ContactDAO;
import hibernate.dao.ContactDAOImpl;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */

//Фабрика DAO
public final class FactoryDAO {

    private static ContactDAO contactDAO;

    private FactoryDAO() {}

    public static ContactDAO getContactDAO() {
        if (contactDAO == null) {
            contactDAO = new ContactDAOImpl();
        }
        return contactDAO;
    }

}
