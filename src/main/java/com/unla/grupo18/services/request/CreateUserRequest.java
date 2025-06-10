package com.unla.grupo18.services.request;

public record CreateUserRequest(String name , String pass , CreateUserContactRequest contact) {
}
