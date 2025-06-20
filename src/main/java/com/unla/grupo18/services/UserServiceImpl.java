package com.unla.grupo18.services;

import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Role;
import com.unla.grupo18.model.User;
import com.unla.grupo18.repositories.IClientRepository;
import com.unla.grupo18.repositories.IRoleRepository;
import com.unla.grupo18.repositories.IUserRepository;
import com.unla.grupo18.services.abstraction.IUserService;
import com.unla.grupo18.services.mapper.UserMapper;
import com.unla.grupo18.services.request.CreateUserRequest;
import com.unla.grupo18.services.response.CreateUserResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository repository;
    private final IClientRepository clientRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(IUserRepository repository, IClientRepository clientRepository, IRoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User user = repository.save(UserMapper.toModel(request));
        return UserMapper.toResponse(user);
    }

    @Override
    public void validateUserSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
                Optional<User> user = repository.findByUsername(userDetails.getUsername());
                userId = user.map(User::getId).orElse(null);
                session.setAttribute("userId", userId);
            }
        }
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

    @Override
    public void register(String username, String password, String name, String lastName, String dni) {
        clientRepository.findByUsername(username).ifPresent(u -> { throw new RuntimeException("El nombre de usuario ya está en uso"); });

        Client client = new Client(username, passwordEncoder.encode(password), name, lastName, dni);
        Role role = roleRepository.findByName("client")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        client.setRole(role);
        clientRepository.save(client);
    }
}
