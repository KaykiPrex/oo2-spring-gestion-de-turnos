package com.unla.grupo18.services.response;

public record GetUserResponse(int id, String name , String pass , CreateUserContactResponse contact) {
}
