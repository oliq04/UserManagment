package com.oliq04.usermanagment.repository;

import lombok.RequiredArgsConstructor;
import com.oliq04.usermanagment.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final List<User> users;
    private Long userCounter;

    public UserRepository() {
        users = new ArrayList<>();
        userCounter = 0L;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        User user = findById(id).orElseThrow(IllegalArgumentException::new);
        users.remove(user);
    }

    public User add(User newUser) {
        newUser.setId(userCounter);
        users.add(newUser);
        userCounter++;
        return newUser;
    }

    public User modifyById(Long id, User newInfo) {
        User user = findById(id).orElseThrow(IllegalArgumentException::new);

        user.setId(id);
        user.setPassword(newInfo.getPassword());
        user.setEmail(newInfo.getEmail());
        user.setFirstName(newInfo.getFirstName());
        user.setLastName(newInfo.getLastName());
        user.setDateOfRegistration(newInfo.getDateOfRegistration());

        return user;
    }
}
