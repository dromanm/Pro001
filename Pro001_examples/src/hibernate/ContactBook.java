package hibernate;

import hibernate.util.HibernateUtil;


/**
 * Created by IEvgen Boldyr on 29.01.17.
 */
public class ContactBook {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}
