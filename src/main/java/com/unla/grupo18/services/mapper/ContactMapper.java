package com.unla.grupo18.services.mapper;

import com.unla.grupo18.model.Contact;
import com.unla.grupo18.services.response.CreateUserContactResponse;

public class ContactMapper {
    public static CreateUserContactResponse toResponse(Contact contact) {
        return new CreateUserContactResponse(contact.getWorkEmail() , contact.getPersonalEmail(), contact.getPhone(), contact.getMobile());
    }
}
