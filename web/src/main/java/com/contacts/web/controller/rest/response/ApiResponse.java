package com.contacts.web.controller.rest.response;

import com.contacts.domain.AbstractDomain;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiResponse implements Serializable {

    private List<? extends AbstractDomain> domains;

    private Map<String, String> messages;

    public List<? extends AbstractDomain> getDomains() {
        return domains;
    }

    public void setDomains(List<? extends AbstractDomain> domains) {
        this.domains = domains;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    public void fillMessagesWithErrors(Errors errors) {
        for (FieldError error: errors.getFieldErrors()) {
            messages.put(error.getField(), error.getDefaultMessage());
        }
    }

    @PostConstruct
    public void init() {
        domains = new ArrayList<AbstractDomain>();
        messages = new HashMap<String, String>();
    }

}
