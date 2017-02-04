package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 02/02/2017.
 */
public class NotebookDAOImpl implements NotebookDAO {
    private SessionFactory factory;

    public NotebookDAOImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notebook> findAll() {
        return factory.openSession().createCriteria(Notebook.class).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notebook> delete(String model) {
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("model", model));
            List<Notebook> resultList = criteria.list();

            session.beginTransaction();
            for (Notebook notebook : resultList) {
                session.delete(notebook);
            }
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notebook> find(String vendor) {
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("vendor", vendor));
            return criteria.list();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notebook> find(double price, int manufYear) {
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.eq("price", price));
            criteria.add(Restrictions.sqlRestriction("YEAR(MANUFACTURE_DATE) = ?", manufYear, IntegerType.INSTANCE));
            return criteria.list();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Notebook> find(double lowestPrice, double highestPrice, Date highestDate, String vendor) {
        Session session = factory.openSession();
        try {
            Criteria criteria = session.createCriteria(Notebook.class);
            criteria.add(Restrictions.between("price", lowestPrice, highestPrice));
            criteria.add(Restrictions.lt("manufDate", highestDate));
            criteria.add(Restrictions.eq("vendor", vendor));
            return criteria.list();
        } finally {
            session.close();
        }
    }


}
