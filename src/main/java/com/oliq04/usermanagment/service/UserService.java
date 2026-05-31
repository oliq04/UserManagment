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

    public User modifyUser(Long id, User newInfo) {
        User user = getUser(id);

        user.setId(id);
        user.setPassword(newInfo.getPassword());
        user.setEmail(newInfo.getEmail());
        user.setFirstName(newInfo.getFirstName());
        user.setLastName(newInfo.getLastName());
        user.setDateOfRegistration(newInfo.getDateOfRegistration());

        return user;
    }

    public User createUser(User newUser) {
        return userRepository.add(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

