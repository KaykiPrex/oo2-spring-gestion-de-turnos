package com.unla.grupo18.services.mapper;

import com.unla.grupo18.model.Contact;
import com.unla.grupo18.model.User;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import com.unla.grupo18.services.response.GetUserResponse;

public class UserMapper {
    public static User toModel(CreateUserRequest request) {
        Contact contact = new Contact();
        contact.setMobile(request.contact().mobile());
        contact.setPhone(request.contact().phone());
        contact.setWorkEmail(request.contact().workEmail());
        contact.setPersonalEmail(request.contact().personalEmail());

        User user = new User();
        user.setName(request.name());
        user.setPassword(request.pass());
        contact.setUser(user);
        user.setContact(contact);

        return user;
    }

    public static CreateUserResponse toResponse(User user) {
        return new CreateUserResponse(user.getId(), user.getUsername(), user.getPassword(), ContactMapper.toResponse(user.getContact()));
    }

    public static GetUserResponse toGetuserResponse(User user) {
        return new GetUserResponse(user.getId(), user.getUsername(), user.getPassword(), ContactMapper.toResponse(user.getContact()));
    }

}
