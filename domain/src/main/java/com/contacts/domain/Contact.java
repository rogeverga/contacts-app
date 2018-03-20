package com.contacts.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact extends AbstractDomain {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Nome não pode ser vazio")
    public String name;

    @Column(name = "phone")
    @NotBlank(message = "Telefone não pode ser vazio")
    public String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
