package jdbcgraph.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdbcgraph.JDBCGraphEx;
import jdbcgraph.domain.Contact;

import java.io.IOException;
import java.sql.*;
import java.util.Locale;

/**
 * Created by IEvgen Boldyr on 22.01.17.
 */

public class JDBCGraphMainController {

    private static String url      = "jdbc:mysql://localhost:3306/FirstDB";
    private static String user     = "root";
    private static String password = "root";

    private ObservableList<Contact> contacts;

    @FXML private TableView<Contact> tblContacts;
    @FXML private TableColumn<Contact, Integer> clnId;
    @FXML private TableColumn<Contact, String> clnName;
    @FXML private TableColumn<Contact, String> clnSurname;
    @FXML private TableColumn<Contact, Integer> clnAge;
    @FXML private TableColumn<Contact, Integer> clnPhone;
    @FXML private TableColumn<Contact, String> clnEmail;

    @FXML
    public void initialize() {
        contacts = FXCollections.observableArrayList();
        try {
            Locale.setDefault(Locale.ENGLISH);
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM CONTACTS");
            while (res.next()) {
                contacts.add(new Contact(
                        res.getInt("ID"),
                        res.getString("NAME"),
                        res.getString("SURNAME"),
                        res.getInt("AGE"),
                        res.getString("EMAIL"),
                        res.getInt("PHONE")
                ));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        clnId.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("id"));
        clnName.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
        clnSurname.setCellValueFactory(new PropertyValueFactory<Contact, String>("surname"));
        clnAge.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("age"));
        clnEmail.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
        clnPhone.setCellValueFactory(new PropertyValueFactory<Contact, Integer>("phone"));

        tblContacts.setItems(contacts);
    }

    @FXML
    public void onActionInsertButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(JDBCGraphEx.class.getResource("/jdbcgraph/new_contact.fxml"));
        GridPane page = (GridPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("New Contact");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(tblContacts.getScene().getWindow());
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void onActionExitButton() {
        System.exit(0);
    }
}
