package hw6.notes.view.controller.edit;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.util.InputDataChecker;
import hw6.notes.util.TableViewHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by eriol4ik on 04/02/2017.
 */
public class DeleteController implements EditController {
    @FXML private TableView<Notebook> notesTable;
          private ObservableList<Notebook> notes;

    @FXML private TableColumn<Notebook, Long> id;
    @FXML private TableColumn<Notebook, String> serial;
    @FXML private TableColumn<Notebook, String> vendor;
    @FXML private TableColumn<Notebook, String> model;
    @FXML private TableColumn<Notebook, Date> manufDate;
    @FXML private TableColumn<Notebook, Double> price;

    @FXML private TextField modelField;
    @FXML private TextField idField;
    @FXML private RadioButton deleteByModel;
    @FXML private RadioButton deleteById;
    @FXML private ToggleGroup group1;

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
        List<Notebook> deletedNotebooks;
        if (group1.getSelectedToggle() == deleteByModel) {
            String model = InputDataChecker.checkString(modelField);
            if (model != null) {
                deletedNotebooks = service.delete(model);
                if (deletedNotebooks != null && !deletedNotebooks.isEmpty()) {
                    notes.addAll(deletedNotebooks);
                    changed = true;
                    undo.setDisable(false);
                }
            }
        }
        if (group1.getSelectedToggle() == deleteById) {
            Long id = InputDataChecker.checkLong(idField);
            if (id != null) {
                Notebook delNotebook = service.delete(id);
                if (delNotebook != null) {
                    notes.addAll(delNotebook);
                    changed = true;
                    undo.setDisable(false);
                }
            }
        }


    }

    @FXML
    public void undo() {
        if (!notes.isEmpty()) {
            for (Notebook notebook : notes) {
                service.add(notebook);
            }
            notes.clear();
            undo.setDisable(true);
        }
    }

    @FXML void selectModel() {
        modelField.setDisable(false);
        idField.setDisable(true);
        idField.setStyle("-fx-border-color: inherit");
    }

    @FXML void selectId() {
        idField.setDisable(false);
        modelField.setDisable(true);
        modelField.setStyle("-fx-border-color: inherit");
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
