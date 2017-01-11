package homeWork01.controllers;

/**
 * Created by Prigovor on 25.12.2016.
 */

import homeWork01.interfaces.impl.CollectionAddressBook;
import homeWork01.objects.Person;
import homeWork01.utils.DialogManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    private Stage mainStage;

    @FXML
    private TableView tableAddressBook;

    @FXML
    private TableColumn<Person, String> clmnName;

    @FXML
    private TableColumn<Person, String> clmnSurname;

    @FXML
    private TableColumn<Person, String> clmnAge;

    @FXML
    private TableColumn<Person, String> clmnBirthDate;

    @FXML
    private TextField fldTextField;

    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private EditDialogController editDialogController;

    private Stage editDialogStage;

    private ResourceBundle resourceBundle;

    private ObservableList<Person> backupList;


    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        clmnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        clmnSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("surname"));
        clmnAge.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        clmnBirthDate.setCellValueFactory(new PropertyValueFactory<Person, String>("birthDate"));
        initListeners();
        fillData();
        initLoader();
    }

    private void fillData() {
        backupList = FXCollections.observableArrayList();
        backupList.addAll(addressBookImpl.getPersonList());
        tableAddressBook.setItems(addressBookImpl.getPersonList());
    }

    private void initListeners() {
        tableAddressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
    }

    private void initLoader() {
        try {
            fxmlLoader.setLocation(getClass().getResource("/homeWork01/fxml/EditFXML.fxml"));
            fxmlLoader.setResources(ResourceBundle.getBundle("homeWork01.bundles.Locale", new Locale("ru")));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionButtonPressed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        // если нажата не кнопка - выходим из метода
        if (!(source instanceof Button)) {
            return;
        }
        Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
        Button clickedButton = (Button) source;
        switch (clickedButton.getId()) {
            case "btnAdd":
                editDialogController.setPerson(new Person());
                showDialog();
                addressBookImpl.add(editDialogController.getPerson());
                break;
            case "btnPrint":
                if (!personIsSelected(selectedPerson)) {
                    return;
                }
                editDialogController.setPerson(selectedPerson);
                showDialog();
                break;
            case "btnSave":
                if (!personIsSelected(selectedPerson)) {
                    return;
                }
                addressBookImpl.delete(selectedPerson);
                break;
        }

    }

    private boolean personIsSelected(Person selectedPerson) {
        if (selectedPerson == null) {
            DialogManager.showErrorDialog(resourceBundle.getString("error"), resourceBundle.getString("Выберите пользователя."));
            return false;
        }
        return true;
    }

    private void showDialog() {
        if (editDialogStage == null) {
            editDialogStage = new Stage();
            editDialogStage.setMinHeight(200);
            editDialogStage.setMinWidth(400);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }
        editDialogStage.showAndWait(); // для ожидания закрытия окна
    }

    public void actionSearch(ActionEvent actionEvent) {
        addressBookImpl.getPersonList().clear();
        for (Person person : backupList) {
            if (person.getName().toLowerCase().contains(fldTextField.getText().toLowerCase()) ||
                    person.getSurname().toLowerCase().contains(fldTextField.getText().toLowerCase()) ||
                    Integer.toBinaryString(person.getAge()).toLowerCase().contains(fldTextField.getText().toLowerCase()) ||
                    person.getBirthDate().toLowerCase().contains(fldTextField.getText().toLowerCase())) {
                addressBookImpl.getPersonList().add(person);
            }
        }
    }
}