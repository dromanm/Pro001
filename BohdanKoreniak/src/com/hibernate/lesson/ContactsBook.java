package com.hibernate.lesson;

import com.hibernate.lesson.service.ContactService;
import com.hibernate.lesson.service.ContactServiceImpl;
import com.hibernate.lesson.entity.Contact;

import java.util.List;

/**
 * Created by Bohdan on 29.01.2017.
 */
public class ContactsBook
{
    public static void main(String[] args)
    {
        ContactService contactService = new ContactServiceImpl();
        List<Contact> listContacts = contactService.findAll();
        System.out.println(listContacts);
    }
}
