package com.contacts.web.controller.rest;

import com.contacts.business.service.ContactService;
import com.contacts.domain.Contact;
import com.contacts.web.controller.rest.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @DeleteMapping("/contact/{id}")
    public ApiResponse delete(@PathVariable("id") Long id) {
        contactService.delete(id);

        ApiResponse apiResponse = getApiResponse();

        return apiResponse;
    }

    @GetMapping("/getAllContacts")
    public ApiResponse getAllContacts() {
        ApiResponse apiResponse = getApiResponse();

        apiResponse.setDomains(contactService.getAllContacts());

        return apiResponse;
    }

    @PostMapping("/contact")
    public ApiResponse insert(@Valid @RequestBody Contact contact, Errors errors) {
        ApiResponse apiResponse = getApiResponse();

        if (errors.hasErrors()) {
            apiResponse.fillMessagesWithErrors(errors);

        } else {
            contactService.insert(contact);
        }

        return apiResponse;
    }

    @PutMapping("/contact")
    public ApiResponse update(@Valid @RequestBody Contact contact, Errors errors) {
        ApiResponse apiResponse = getApiResponse();

        if (errors.hasErrors()) {
            apiResponse.fillMessagesWithErrors(errors);

        } else {
            contactService.update(contact);
        }

        return apiResponse;
    }

    @Lookup
    public ApiResponse getApiResponse() {
        return null;
    }

}
