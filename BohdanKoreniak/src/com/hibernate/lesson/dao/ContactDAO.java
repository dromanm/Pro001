package com.hibernate.lesson.dao;

import com.hibernate.lesson.entity.Contact;

import java.util.List;

/**
 * Created by Bohdan on 29.01.2017.
 */
public interface ContactDAO
{
    Long createContact(Contact contact);

    Contact readContact(Long id);

    void updateContact(Contact contact);

    void deleteContact(Contact contact);

    List<Contact> findAll();
}
