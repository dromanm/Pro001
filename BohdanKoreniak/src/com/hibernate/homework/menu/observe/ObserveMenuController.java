package com.hibernate.homework.menu.observe;

import com.hibernate.homework.entity.Laptop;
import com.hibernate.homework.menu.Controller;
import com.hibernate.homework.menu.DatabaseManagerModel;
import com.hibernate.homework.menu.Main;
import com.hibernate.homework.menu.View;
import com.hibernate.homework.menu.add.AddMenuController;
import com.hibernate.homework.menu.update.UpdateMenuController;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.Column;
import java.lang.reflect.Field;

/**
 * Created by Bohdan on 13.12.2016.
 */
public class ObserveMenuController implements Controller
{
    private DatabaseManagerModel databaseManagerModel = DatabaseManagerModel.getInstance();

    private ObserveMenuModel model = new ObserveMenuModel();
    private ObserveMenuView view = new ObserveMenuView(this);

    public ObserveMenuModel getModel()
    {
        return model;
    }

    @Override
    public View getView()
    {
        return view;
    }

    public void showTable(Class annotatedClass)
    {
        view.getTableView().getColumns().clear();

        for (Field field : annotatedClass.getDeclaredFields())
        {
            TableColumn tableColumn = new TableColumn(field.getAnnotation(Column.class).name());
            view.getTableView().getColumns().add(tableColumn);
            tableColumn.setCellValueFactory(new PropertyValueFactory(field.getName()));
        }

        view.getTableView().setItems(FXCollections.observableList(databaseManagerModel.getDatabaseManager().getEntries(annotatedClass)));
    }

    public void addEntry()
    {
        Main.getInstance().replaceSceneContent(new AddMenuController(Laptop.class));
    }

    public void updateEntry()
    {
        Main.getInstance().replaceSceneContent(new UpdateMenuController(model.getSelectedEntry()));
    }

    public void deleteEntry()
    {
        try
        {
            Field id = model.getSelectedEntry().getClass().getDeclaredField("id");
            id.setAccessible(true);

            databaseManagerModel.getDatabaseManager().deleteEntry(
                    (Integer) id.get(model.getSelectedEntry()), model.getSelectedEntry().getClass());
        }
        catch (IllegalAccessException | NoSuchFieldException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }
}
