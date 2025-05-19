package com.unla.grupo18.services.response;

public record CreateUserResponse(int id, String name , String pass , CreateUserContactResponse contact) {
}
