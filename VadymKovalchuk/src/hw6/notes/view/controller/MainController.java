package hw6.notes.view.controller;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.util.TableViewHelper;
import hw6.notes.view.controller.edit.EditController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by eriol4ik on 03/02/2017.
 */
public class MainController {
    @FXML private TableView<Notebook> notesTable;
          private ObservableList<Notebook> notes;
    @FXML private TableColumn<Notebook, Long> id;
    @FXML private TableColumn<Notebook, String> serial;
    @FXML private TableColumn<Notebook, String> vendor;
    @FXML private TableColumn<Notebook, String> model;
    @FXML private TableColumn<Notebook, Date> manufDate;
    @FXML private TableColumn<Notebook, Double> price;


    private NotebookService service;

    public void initialize() {
        notes = FXCollections.observableArrayList();

        TableViewHelper.setCells(
                id, serial, vendor, model, manufDate, price);

        notesTable.setItems(notes);

        service = new NotebookServiceImpl();

        updateTable(true);
    }

    protected void updateTable(Boolean isChanged) {
        if (isChanged) notes.setAll(service.findAll());
    }

    @FXML
    public void add() throws IOException {
        loadAndShowAndWait("/hw6/notes/view/edit/add.fxml", "Add notebook");
    }

    @FXML
    public void deleteByModel() throws IOException {
        loadAndShowAndWait("/hw6/notes/view/edit/delete_by_model.fxml", "Delete by model");
    }

    @FXML
    public void deleteById() {

    }

    @FXML
    public void changePriceById() {

    }

    @FXML
    public void changeSerialVendorById() {

    }

    @FXML
    public void findByVendor() {

    }

    @FXML
    public void findByPriceDate() {

    }

    @FXML
    public void findByVendorPriceDate() {

    }

    private void loadAndShowAndWait(String resource, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initOwner(notesTable.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        EditController controller = loader.getController();
        controller.setService(service);

        stage.showAndWait();

        updateTable(controller.isChanged());
    }
}
