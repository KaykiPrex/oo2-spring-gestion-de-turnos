package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.model.User;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import jakarta.servlet.http.HttpSession;

public interface IUserService {
    CreateUserResponse create(CreateUserRequest request);
    void validateUserSession(HttpSession session);
    User update(User user);
    void delete(int id);
    User findById(int id);

    void register(String username, String password, String name, String lastName, String dni);
}
