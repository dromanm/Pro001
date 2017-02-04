package hw6.notes.util;

import hw6.notes.domain.Notebook;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

/**
 * Created by eriol4ik on 04/02/2017.
 */
public class TableViewHelper {
    public static void setCells(TableColumn<Notebook, Long> id,
                                TableColumn<Notebook, String> serial,
                                TableColumn<Notebook, String> vendor,
                                TableColumn<Notebook, String> model,
                                TableColumn<Notebook, Date> manufDate,
                                TableColumn<Notebook, Double> price) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        serial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        vendor.setCellValueFactory(new PropertyValueFactory<>("vendor"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        manufDate.setCellValueFactory(new PropertyValueFactory<>("manufDate"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
