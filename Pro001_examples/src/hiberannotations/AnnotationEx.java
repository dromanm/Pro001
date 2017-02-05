package hiberannotations;

import hiberannotations.entity.Author;
import hiberannotations.entity.Book;
import hiberannotations.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by IEvgen Boldyr on 04.02.17.
 */
public class AnnotationEx {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Book book = new Book("SOME_BOOK");
        Author author = new Author("NAME", "SURNAME");
        author.setBook(book);

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();

        session.close();

        HibernateUtil.getSessionFactory().close();
    }

}
