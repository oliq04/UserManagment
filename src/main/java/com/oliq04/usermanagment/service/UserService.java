package com.oliq04.usermanagment.service;

import com.oliq04.usermanagment.model.User;
import com.oliq04.usermanagment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public User modifyUser(Long id, User user) {
        return userRepository.modifyById(id, user);
    }

    public User createUser(User newUser) {
        return userRepository.add(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

