package hw6.notes.util;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by eriol4ik on 03/02/2017.
 */
public class InputDataChecker {
    public static Date checkDate(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        if (localDate == null) {
            datePicker.setStyle("-fx-border-color: red");
            return null;
        }

        datePicker.setStyle("-fx-border-color: inherit");
        return Date.valueOf(localDate);
    }

    public static String checkString(TextField textField) {
        String text = textField.getText();
        if (text.trim().isEmpty()) {
            textField.setStyle("-fx-border-color: red");
            return null;
        }

        textField.setStyle("-fx-border-color: inherit");
        return text;
    }

    public static Double checkDouble(TextField textField) {
        String text = textField.getText();
        if (text.trim().isEmpty()) {
            textField.setStyle("-fx-border-color: red");
            return null;
        }

        Double num;
        try {
            num = Double.parseDouble(text);
        } catch (NumberFormatException nfe) {
            textField.setStyle("-fx-border-color: red");
            return null;
        }

        textField.setStyle("-fx-border-color: inherit");
        return num;
    }
}
