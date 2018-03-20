package com.contacts.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/alterarDadosContato.html")
    public String updateContact() {
        return "update_contact.html";
    }

    @GetMapping("/cadastrarNovoContato.html")
    public String insertNewContact() {
        return "insert_new_contact.html";
    }

}
