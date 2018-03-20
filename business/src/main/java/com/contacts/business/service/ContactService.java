package com.contacts.business.service;

import com.contacts.domain.Contact;
import com.contacts.domain.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public void delete(Long id) {
        contactRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Transactional
    public Contact insert(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

}
