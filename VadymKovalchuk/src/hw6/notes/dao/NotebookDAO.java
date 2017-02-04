package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 02/02/2017.
 */
public interface NotebookDAO {
    Long create(Notebook ntb);

    Notebook read(Long id);

    boolean update(Notebook ntb);

    boolean delete(Notebook ntb);

    List<Notebook> findAll();

    List<Notebook> delete(String model);

    Notebook delete(Long id);

    List<Notebook> find(String vendor);

    List<Notebook> find(double price, int manufYear);

    List<Notebook> find(double lowestPrice, double highestPrice,
                        Date highestDate, String vendor);
}
