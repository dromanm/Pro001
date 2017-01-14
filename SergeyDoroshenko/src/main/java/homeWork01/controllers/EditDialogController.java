package homeWork01.controllers;

import homeWork01.objects.Person;
import homeWork01.utils.DialogManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Prigovor on 25.12.2016.
 */

public class EditDialogController implements Initializable {

    @FXML
    private TextField fldName;

    @FXML
    private TextField fldSurname;

    @FXML
    private TextField fldAge;

    @FXML
    private TextField fldBirthDate;

    private Person person;

    private ResourceBundle resourceBundle;


    public void setPerson(Person person) {
        if (person == null) {
            return;
        }
        this.person = person;
        fldName.setText(person.getName());
        fldSurname.setText(person.getSurname());
        fldAge.setText(Integer.toString(person.getAge()));
        fldBirthDate.setText(person.getBirthDate());
    }

    public Person getPerson() {
        return person;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void actionSave(ActionEvent actionEvent) {
        if (!checkValues()) {
            return;
        }
        person.setName(fldName.getText());
        person.setSurname(fldSurname.getText());
        person.setAge(Integer.valueOf(fldAge.getText()));
        person.setBirthDate(fldBirthDate.getText());
        actionClose(actionEvent);
    }

    private boolean checkValues() {
        if (fldName.getText().trim().length() == 0 || fldSurname.getText().trim().length() == 0 ||
            fldAge.getText().trim().length() == 0 || fldBirthDate.getText().trim().length() == 0) {
            DialogManager.showInfoDialog("Ошибка вода", "Заполните все поля");
            return false;
        }
        return true;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }
}
