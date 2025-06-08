package com.unla.grupo18.services;

import com.unla.grupo18.model.User;
import com.unla.grupo18.repositories.IUserRepository;
import com.unla.grupo18.services.mapper.UserMapper;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User user = repository.save(UserMapper.toModel(request));
        return UserMapper.toResponse(user);
    }


    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findById(int id) {
        return null;
    }
}
