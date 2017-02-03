package com.hibernate.homework.menu.add;

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
public class AddMenuController implements Controller
{
    private AddMenuModel model = new AddMenuModel();
    private AddMenuView view;

    public AddMenuController(Class entityClass)
    {
        model.setEntityClass(entityClass);
        view = new AddMenuView(this);
    }

    @Override
    public View getView()
    {
        return view;
    }

    public AddMenuModel getModel()
    {
        return model;
    }

    public void addEntry()
    {
        try
        {
            Object objectEntry = model.getEntityClass().newInstance();

            Field[] declaredFields = model.getEntityClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++)
            {
                Field field = declaredFields[i];
                field.setAccessible(true);

                if (!field.getType().equals(String.class))
                {
                    field.set(objectEntry, field.getType()
                            .getDeclaredMethod("valueOf", String.class)
                            .invoke(null, view.getTextFieldList().get(i).getText()));
                }
                else
                {
                    field.set(objectEntry, view.getTextFieldList().get(i).getText());
                }
            }

            DatabaseManagerModel.getInstance().getDatabaseManager().saveEntry(objectEntry);

            Main.getInstance().replaceSceneContent(new ObserveMenuController());
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e)
        {
            view.showInformationMessage("Please, enter correct data");
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new ObserveMenuController());
    }
}
