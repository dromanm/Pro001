package com.hibernate.homework.menu.update;

import com.hibernate.homework.menu.Controller;
import com.hibernate.homework.menu.DatabaseManagerModel;
import com.hibernate.homework.menu.Main;
import com.hibernate.homework.menu.View;
import com.hibernate.homework.menu.observe.ObserveMenuController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Bohdan on 03.02.2017.
 */
public class UpdateMenuController implements Controller
{
    private UpdateMenuModel model = new UpdateMenuModel();
    private UpdateMenuView view;

    public UpdateMenuModel getModel()
    {
        return model;
    }

    @Override
    public View getView()
    {
        return view;
    }

    public UpdateMenuController(Object entryObject)
    {
        model.setEntryObject(entryObject);
        view = new UpdateMenuView(this);
    }

    public void updateEntry()
    {
        try
        {
            Field[] declaredFields = model.getEntryObject().getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++)
            {
                Field field = declaredFields[i];
                field.setAccessible(true);

                if (!field.getType().equals(String.class))
                {
                    field.set(model.getEntryObject(), field.getType()
                            .getDeclaredMethod("valueOf", String.class)
                            .invoke(null, view.getTextFieldList().get(i).getText()));
                }
                else
                {
                    field.set(model.getEntryObject(), view.getTextFieldList().get(i).getText());
                }
            }

            DatabaseManagerModel.getInstance().getDatabaseManager().updateEntry(model.getEntryObject());

            Main.getInstance().replaceSceneContent(new ObserveMenuController());
        }
        catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            view.showInformationMessage("Please, enter correct data");
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new ObserveMenuController());
    }
}
