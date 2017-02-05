package com.hibernate.homework.menu.update;

import com.hibernate.homework.menu.View;
import com.hibernate.homework.menu.constants.GuiElementSizeConstants;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 03.02.2017.
 */
public class UpdateMenuView implements View
{
    private UpdateMenuModel model;
    private UpdateMenuController controller;

    private GridPane gridPane = new GridPane();

    private Button buttonAdd = new Button();
    private Button buttonCancel = new Button();

    private List<TextField> textFieldList = new ArrayList<>();

    public UpdateMenuView(UpdateMenuController controller)
    {
        this.controller = controller;
        model = controller.getModel();
        initView();
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    public List<TextField> getTextFieldList()
    {
        return textFieldList;
    }

    @Override
    public void initView()
    {
        int row = 0;
        for (Field field : model.getEntryObject().getClass().getDeclaredFields())
        {
            try
            {
                Label label = new Label(field.getAnnotation(Column.class).name());
                label.setAlignment(Pos.CENTER_RIGHT);

                TextField textField = new TextField();

                field.setAccessible(true);
                textField.setText(String.valueOf(field.get(model.getEntryObject())));

                textFieldList.add(textField);

                gridPane.add(label, 0, row);
                gridPane.add(textField, 1, row);

                row++;
            }
            catch (IllegalAccessException e)
            {
                showInformationMessage(e.getMessage());
            }
        }

        textFieldList.get(0).setEditable(false);

        buttonAdd.setText("Update entry");
        buttonAdd.setAlignment(Pos.CENTER);
        buttonAdd.setMinSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);
        buttonAdd.setOnAction(event ->
        {
            controller.updateEntry();
        });

        buttonCancel.setText("Cancel");
        buttonCancel.setAlignment(Pos.CENTER);
        buttonCancel.setMaxSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);
        buttonCancel.setOnAction(event ->
        {
            controller.cancel();
        });

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(GuiElementSizeConstants.INSETS_VALUE);
        gridPane.setVgap(GuiElementSizeConstants.INSETS_VALUE);

        gridPane.add(buttonAdd, 0, row);
        gridPane.add(buttonCancel, 1, row);
    }
}
