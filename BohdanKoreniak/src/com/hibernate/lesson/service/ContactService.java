package com.hibernate.lesson.service;

import com.hibernate.lesson.entity.Contact;

import java.util.List;

/**
 * Created by Bohdan on 29.01.2017.
 */
public interface ContactService
{
    void createContact(Contact contact);

    List<Contact> findAll();
}
