package com.hibernate.homework.menu;

import com.hibernate.homework.entity.Laptop;
import com.hibernate.homework.managers.DatabaseManager;

/**
 * Created by Bohdan on 03.02.2017.
 */
public class DatabaseManagerModel
{
    private static DatabaseManagerModel instance;
    public static DatabaseManagerModel getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseManagerModel();
        }
        return instance;
    }
    private DatabaseManagerModel()
    {
    }

    private DatabaseManager databaseManager = new DatabaseManager(Laptop.class);

    public DatabaseManager getDatabaseManager()
    {
        return databaseManager;
    }
}
