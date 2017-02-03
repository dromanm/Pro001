package w5.jdbc.task2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import w5.jdbc.task2.model.Contact;
import w5.jdbc.task2.model.Model;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Controller
{
    private Model model = new Model();

    @FXML private TableView<Contact> tableViewContacts;

    @FXML
    public void initialize()
    {
        for (Field field : Contact.class.getDeclaredFields())
        {
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));

            tableViewContacts.getColumns().add(tableColumn);
        }

        refreshView();
    }

    public void refreshView()
    {
        tableViewContacts.getItems().clear();

        tableViewContacts.getItems().addAll(model.getAllContacts());
    }

    @FXML
    public void onActionInsertButton()
    {
        Contact contact = new Contact(13, "ASdasd", "Assad", 123, "sfaf", 12311);
        model.insertNewContact(contact);

        refreshView();
    }

    @FXML
    public void onActionExitButton()
    {

    }
}
