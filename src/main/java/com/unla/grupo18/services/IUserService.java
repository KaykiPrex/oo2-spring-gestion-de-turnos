package com.unla.grupo18.services;

import com.unla.grupo18.model.User;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;

public interface IUserService {
    CreateUserResponse create(CreateUserRequest request);
    User update(User user);
    void delete(int id);
    User findById(int id);
}
