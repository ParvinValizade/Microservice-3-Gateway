package com.company.microservice3gateway.service;

import com.company.microservice3gateway.dto.CreateUserRequest;
import com.company.microservice3gateway.dto.UserDto;
import com.company.microservice3gateway.dto.converter.UserDtoConverter;
import com.company.microservice3gateway.exception.UserAlreadyExistException;
import com.company.microservice3gateway.exception.UserNotFoundException;
import com.company.microservice3gateway.model.User;
import com.company.microservice3gateway.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter converter;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, UserDtoConverter converter) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.converter = converter;
    }

    public UserDto createUser(CreateUserRequest request){
        checkUserIsAlreadyExistOrNot(request.getUsername());
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getName(),
                LocalDateTime.now()
        );
        return converter.convert(repository.save(user));
    }

    public UserDto findUserByUserName(String username){
        return converter.convert(findUser(username));
    }

    public List<UserDto> getAllUsers(){
        return converter.convert(repository.findAll());
    }

    private void checkUserIsAlreadyExistOrNot(String username){
        Optional<User> user = repository.findByUsername(username);
        user.ifPresent(user1 -> {throw new UserAlreadyExistException("User Already Exist");});
    }

    private User findUser(String username){
        return repository.findByUsername(username)
                .orElseThrow(()->new UserNotFoundException("User couldn't be found by following username: "+username));
    }
}
