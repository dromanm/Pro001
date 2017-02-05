package com.hibernate.homework.menu.observe;

import com.hibernate.homework.entity.Laptop;
import com.hibernate.homework.menu.View;
import com.hibernate.homework.menu.constants.GuiElementSizeConstants;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

/**
 * Created by Bohdan on 13.12.2016.
 */
public class ObserveMenuView implements View
{
    private ObserveMenuController controller;

    private GridPane gridPane = new GridPane();
    private TableView tableView = new TableView();

    private Button buttonShowTable = new Button();

    private Button buttonAddEntry = new Button();
    private Button buttonDeleteEntry = new Button();
    private Button buttonUpdateEntry = new Button();

    public TableView getTableView()
    {
        return tableView;
    }

    public ObserveMenuView(ObserveMenuController controller)
    {
        this.controller = controller;
        initView();
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    @Override
    public void initView()
    {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(GuiElementSizeConstants.INSETS_VALUE * 4));

        gridPane.add(tableView, 0, 0, 3, 1);

        buttonShowTable.setText("Show table");
        buttonShowTable.setMinSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);
        buttonShowTable.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        gridPane.add(buttonShowTable, 0, 2, 3, 1);

        buttonAddEntry.setText("Add entry");
        buttonDeleteEntry.setText("Delete entry");
        buttonUpdateEntry.setText("Update entry");

        buttonAddEntry.setMinSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);
        buttonDeleteEntry.setMinSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);
        buttonUpdateEntry.setMinSize(GuiElementSizeConstants.MIN_WIDTH, GuiElementSizeConstants.MIN_HEIGHT);

        gridPane.add(buttonAddEntry, 0, 1);
        gridPane.add(buttonDeleteEntry, 1, 1);
        gridPane.add(buttonUpdateEntry, 2, 1);

        gridPane.setHgap(GuiElementSizeConstants.INSETS_VALUE);
        gridPane.setVgap(GuiElementSizeConstants.INSETS_VALUE);

        for (Node node : gridPane.getChildren())
        {
            GridPane.setHalignment(node, HPos.CENTER);
            GridPane.setValignment(node, VPos.CENTER);
        }

        buttonShowTable.setOnAction(event ->
        {
            controller.showTable(Laptop.class);
        });

        buttonAddEntry.setOnAction(event ->
        {
            controller.addEntry();
        });

        buttonDeleteEntry.setOnAction(event ->
        {
            controller.deleteEntry();
            controller.showTable(Laptop.class);
        });

        buttonUpdateEntry.setOnAction(event ->
        {
            controller.updateEntry();
        });

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            controller.getModel().setSelectedEntry(newValue);
        });
    }
}
