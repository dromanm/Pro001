package hw6.notes.view.controller.edit;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.util.InputDataChecker;
import hw6.notes.util.TableViewHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 04/02/2017.
 */
public class DeleteByModelController implements EditController {
    @FXML private TableView<Notebook> notesTable;
          private ObservableList<Notebook> notes;

    @FXML private TableColumn<Notebook, Long> id;
    @FXML private TableColumn<Notebook, String> serial;
    @FXML private TableColumn<Notebook, String> vendor;
    @FXML private TableColumn<Notebook, String> model;
    @FXML private TableColumn<Notebook, Date> manufDate;
    @FXML private TableColumn<Notebook, Double> price;

    @FXML private TextField modelField;

    @FXML private Button undo;

    private NotebookService service;

    private boolean changed = false;

    @FXML public void initialize() {
        notes = FXCollections.observableArrayList();

        TableViewHelper.setCells(
                id, serial, vendor, model, manufDate, price);

        notesTable.setItems(notes);
    }

    @FXML
    public void delete() {
        String model = InputDataChecker.checkString(modelField);

        if (model != null) {
            List<Notebook> deletedNotebooks = service.delete(model);
            notes.setAll(deletedNotebooks);
            changed = true;
            undo.setDisable(false);
        }
    }

    @FXML
    public void undo() {
        if (!notes.isEmpty()) {
            for (Notebook notebook : notes) {
                service.add(notebook);
            }
            undo.setDisable(true);
        }
    }

    @Override
    public void setService(NotebookService service) {
        this.service = service;
    }

    @Override
    public boolean isChanged() {
        return changed;
    }
}
