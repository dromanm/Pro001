package hw6.notes.service;

import hw6.notes.dao.NotebookDAO;
import hw6.notes.dao.NotebookDAOImpl;
import hw6.notes.domain.Notebook;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 02/02/2017.
 */
public class NotebookServiceImpl implements NotebookService {
    private NotebookDAO notebookDAO;

    public NotebookServiceImpl() {
        notebookDAO = new NotebookDAOImpl();
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDAO.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDAO.findAll();
    }

    public void update(Notebook ntb) {
        notebookDAO.update(ntb);
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = notebookDAO.read(id);
        notebook.setPrice(price);
        notebookDAO.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = notebookDAO.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notebookDAO.update(notebook);
    }

    @Override
    public List<Notebook> delete(String model) {
        return notebookDAO.delete(model);
    }

    @Override
    public Notebook delete(Long id) {
        return notebookDAO.delete(id);
    }

    @Override
    public List<Notebook> find(String vendor) {
        return notebookDAO.find(vendor);
    }

    @Override
    public List<Notebook> find(double price, int manufYear) {
        return notebookDAO.find(price, manufYear);
    }

    @Override
    public List<Notebook> find(double lowestPrice, double highestPrice, Date highestDate, String vendor) {
        return notebookDAO.find(lowestPrice, highestPrice, highestDate, vendor);
    }
}
