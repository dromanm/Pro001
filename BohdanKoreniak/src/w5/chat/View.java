package w5.chat;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Bohdan on 27.01.2017.
 */
public interface View
{
    void init();
    Parent getParent();

    default void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text, ButtonType.OK).showAndWait();
    }
}
