package hw6.notes.service;

import hw6.notes.domain.Notebook;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 02/02/2017.
 */
public interface NotebookService {
    Long add(Notebook notebook);

    List<Notebook> findAll();

    void changePrice(Long id, double price);

    void changeSerialVendor(Long id, String serial, String vendor);

    List<Notebook> delete(String model);

    List<Notebook> find(String vendor);

    List<Notebook> find(double price, int manufYear);

    List<Notebook> find(double lowestPrice, double highestPrice,
                        Date highestDate, String vendor);
}
