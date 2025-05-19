package com.unla.grupo18.services.request;

import com.unla.grupo18.model.Contact;

public record CreateUserRequest(String name , String pass , Contact contact) {
}
