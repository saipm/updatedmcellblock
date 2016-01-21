package ngdemo.service.contract;

import ngdemo.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getById(String id);

    User createNewUser(User user);

    User update(User user);

    void remove(String id);

    int getNumberOfUsers();
}
