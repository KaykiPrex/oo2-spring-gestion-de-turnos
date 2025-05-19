package com.unla.grupo18.services.mapper;

import com.unla.grupo18.model.Contact;
import com.unla.grupo18.model.User;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;

public class UserMapper {
    public static User toModel(CreateUserRequest request) {
        Contact contact = new Contact();
        contact.setMobile(request.contact().getMobile());
        contact.setPhone(request.contact().getPhone());
        contact.setWorkEmail(request.contact().getWorkEmail());
        contact.setPersonalEmail(request.contact().getPersonalEmail());

        User user = new User();
        user.setName(request.name());
        user.setPass(request.pass());
        contact.setUser(user);
        user.setContact(contact);

        return user;
    }

    public static CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.getId(), user.getName(), user.getPass(), ContactMapper.toResponse(user.getContact()));
    }

}
