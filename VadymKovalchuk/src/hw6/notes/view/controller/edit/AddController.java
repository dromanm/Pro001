package hw6.notes.view.controller.edit;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.util.InputDataChecker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by eriol4ik on 03/02/2017.
 */
public class AddController implements EditController {
    @FXML private TextField serialField;
    @FXML private TextField vendorField;
    @FXML private TextField modelField;
    @FXML private DatePicker datePicker;
    @FXML private TextField priceField;

    @FXML private Button add;

    private boolean changed = false;

    private Notebook notebook;

    private NotebookService service;

    public void initialize() {
        datePicker.setValue(LocalDate.now());
        datePicker.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if(localDate == null || localDate.isAfter(LocalDate.now())) return "";
                else return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if(dateString == null || dateString.trim().isEmpty()) return null;
                else return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    @FXML
    public void add() {
        String serial    =   InputDataChecker.checkString(serialField);
        String vendor    =   InputDataChecker.checkString(vendorField);
        String model     =   InputDataChecker.checkString(modelField);
        Date date        =   InputDataChecker.checkDate(datePicker);
        Double price     =   InputDataChecker.checkDouble(priceField);
        
        if (serial != null && vendor != null && model != null
                && date != null && price != null) {

            notebook = new Notebook(serial, vendor, model,
                    date, price);

            service.add(notebook);
            changed = true;

            ((Stage) add.getScene().getWindow()).close();
        }
    }

    @FXML
    public void cancel() {
        ((Stage) add.getScene().getWindow()).close();
    }

    public Notebook getNotebook() {
        return notebook;
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
