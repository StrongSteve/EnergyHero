package com.energyhero.service.user;

import com.energyhero.domain.User;
import com.energyhero.transfer.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByUserName(String email);

    Collection<User> getAllUsers();

    void removeUser(Long id);

    User saveUser(UserCreateForm userCreateForm);

    void changePassword(Long id, String password);

}
