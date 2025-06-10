package com.unla.grupo18.services;

import com.unla.grupo18.model.User;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import com.unla.grupo18.services.response.GetUserResponse;

public interface IUserService {
    CreateUserResponse create(CreateUserRequest request);
    User update(User user);
    void delete(int id);
    GetUserResponse findById(int id);
}
