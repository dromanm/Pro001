package com.hibernate.homework.menu;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Bohdan on 03.02.2017.
 */
public interface View
{
    Parent getParent();

    void initView();

    default void showInformationMessage(String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
    }
}
