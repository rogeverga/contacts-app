package com.contacts.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = { "com.contacts" })
@EnableJpaRepositories("com.contacts.domain.repository")
@EnableTransactionManagement
@EntityScan("com.contacts.domain")
@SpringBootApplication
public class ContactsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsWebApplication.class, args);
	}

}
